package in.strollup.fb.contract;

import java.util.List;
import javax.annotation.Generated;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Element {

	@SerializedName("title")
	@Expose
	private String title;
	@SerializedName("subtitle")
	@Expose
	private String subtitle;
	@SerializedName("image_url")
	@Expose
	private String imageUrl;
	@SerializedName("buttons")
	@Expose
	private List<Button> buttons; // = new ArrayList<Button>();

	/**
	 * 
	 * @return The title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 
	 * @param title
	 *            The title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 
	 * @return The subtitle
	 */
	public String getSubtitle() {
		return subtitle;
	}

	/**
	 * 
	 * @param subtitle
	 *            The subtitle
	 */
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	/**
	 * 
	 * @return The imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * 
	 * @param imageUrl
	 *            The image_url
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * 
	 * @return The buttons
	 */
	public List<Button> getButtons() {
		return buttons;
	}

	/**
	 * 
	 * @param buttons
	 *            The buttons
	 */
	public void setButtons(List<Button> buttons) {
		this.buttons = buttons;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(title).append(subtitle).append(imageUrl).append(buttons).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Element) == false) {
			return false;
		}
		Element rhs = ((Element) other);
		return new EqualsBuilder().append(title, rhs.title).append(subtitle, rhs.subtitle)
				.append(imageUrl, rhs.imageUrl).append(buttons, rhs.buttons).isEquals();
	}

}
