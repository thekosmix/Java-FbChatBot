package in.strollup.fb.servlet;

import in.strollup.fb.contract.FbMsgRequest;
import in.strollup.fb.contract.Messaging;
import in.strollup.fb.utils.FbChatHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

/**
 * 
 * @author thekosmix
 * 
 *
 */
public class WebHookServlet extends HttpServlet {

	private static final long serialVersionUID = -2326475169699351010L;

	/************* FB Chat Bot variables *************************/
	public static final String PAGE_TOKEN = "YOUR_FB_PAGE_TOKEN";
	private static final String VERIFY_TOKEN = "whatever_string_you_or_your_friends_wish";
	private static final String FB_MSG_URL = "https://graph.facebook.com/v2.6/me/messages?access_token="
			+ PAGE_TOKEN;
	/*************************************************************/

	/******* for making a post call to fb messenger api **********/
	private static final HttpClient client = HttpClientBuilder.create().build();
	private static final HttpPost httppost = new HttpPost(FB_MSG_URL);
	private static final FbChatHelper helper = new FbChatHelper();
	/*************************************************************/

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * get method is used by fb messenger to verify the webhook
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String queryString = request.getQueryString();
		String msg = "Error, wrong token";

		if (queryString != null) {
			String verifyToken = request.getParameter("hub.verify_token");
			String challenge = request.getParameter("hub.challenge");
			// String mode = request.getParameter("hub.mode");

			if (StringUtils.equals(VERIFY_TOKEN, verifyToken)
					&& !StringUtils.isEmpty(challenge)) {
				msg = challenge;
			} else {
				msg = "";
			}
		} else {
			System.out
					.println("Exception no verify token found in querystring:"
							+ queryString);
		}

		response.getWriter().write(msg);
		response.getWriter().flush();
		response.getWriter().close();
		response.setStatus(HttpServletResponse.SC_OK);
		return;
	}

	private void processRequest(HttpServletRequest httpRequest,
			HttpServletResponse response) throws IOException, ServletException {
		/**
		 * store the request body in stringbuffer
		 */
		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = httpRequest.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) {
			e.printStackTrace();
		}

		/**
		 * convert the string request body in java object
		 */
		FbMsgRequest fbMsgRequest = new Gson().fromJson(jb.toString(),
				FbMsgRequest.class);
		if (fbMsgRequest == null) {
			System.out.println("fbMsgRequest was null");
			response.setStatus(HttpServletResponse.SC_OK);
			return;
		}
		List<Messaging> messagings = fbMsgRequest.getEntry().get(0)
				.getMessaging();
		for (Messaging event : messagings) {
			String sender = event.getSender().getId();
			if (event.getMessage() != null
					&& event.getMessage().getText() != null) {
				String text = event.getMessage().getText();
				sendTextMessage(sender, text, false);
			} else if (event.getPostback() != null) {
				String text = event.getPostback().getPayload();
				System.out.println("postback received: " + text);
				sendTextMessage(sender, text, true);
			}
		}
		response.setStatus(HttpServletResponse.SC_OK);
	}

	/**
	 * get the text given by senderId and check if it's a postback (button
	 * click) or a direct message by senderId and reply accordingly
	 * 
	 * @param senderId
	 * @param text
	 * @param isPostBack
	 */
	private void sendTextMessage(String senderId, String text,
			boolean isPostBack) {
		List<String> jsonReplies = null;
		if (isPostBack) {
			jsonReplies = helper.getPostBackReplies(senderId, text);
		} else {
			jsonReplies = helper.getReplies(senderId, text);
		}

		for (String jsonReply : jsonReplies) {
			try {
				HttpEntity entity = new ByteArrayEntity(
						jsonReply.getBytes("UTF-8"));
				httppost.setEntity(entity);
				HttpResponse response = client.execute(httppost);
				String result = EntityUtils.toString(response.getEntity());
				System.out.println(result);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public void destroy() {
		System.out.println("webhook Servlet Destroyed");
	}

	@Override
	public void init() throws ServletException {
		httppost.setHeader("Content-Type", "application/json");
		System.out.println("webhook servlet created!!");
	}
}
