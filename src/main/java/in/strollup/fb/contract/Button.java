package in.strollup.fb.contract;

import javax.annotation.Generated;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Button {

	@SerializedName("type")
	@Expose
	private String type;
	@SerializedName("title")
	@Expose
	private String title;
	@SerializedName("payload")
	@Expose
	private String payload;
	@SerializedName("url")
	@Expose
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 
	 * @return The type
	 */
	public String getType() {
		return type;
	}

	/**
	 * 
	 * @param type
	 *            The type
	 */
	public void setType(String type) {
		this.type = type;
	}

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
	 * @return The payload
	 */
	public String getPayload() {
		return payload;
	}

	/**
	 * 
	 * @param payload
	 *            The payload
	 */
	public void setPayload(String payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(type).append(title).append(payload).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Button) == false) {
			return false;
		}
		Button rhs = ((Button) other);
		return new EqualsBuilder().append(type, rhs.type).append(title, rhs.title).append(payload, rhs.payload)
				.isEquals();
	}

}
