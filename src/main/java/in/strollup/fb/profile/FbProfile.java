package in.strollup.fb.profile;

import javax.annotation.Generated;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class FbProfile {

	@SerializedName("first_name")
	@Expose
	private String firstName;
	@SerializedName("last_name")
	@Expose
	private String lastName;
	@SerializedName("profile_pic")
	@Expose
	private String profilePic;
	@SerializedName("locale")
	@Expose
	private String locale;
	@SerializedName("timezone")
	@Expose
	private String timezone;
	@SerializedName("gender")
	@Expose
	private String gender;

	/**
	 *
	 * @return The firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 *
	 * @param firstName
	 *            The first_name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 *
	 * @return The lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 *
	 * @param lastName
	 *            The last_name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 *
	 * @return The profilePic
	 */
	public String getProfilePic() {
		return profilePic;
	}

	/**
	 *
	 * @param profilePic
	 *            The profile_pic
	 */
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	/**
	 *
	 * @return The locale
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 *
	 * @param locale
	 *            The locale
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}

	/**
	 *
	 * @return The timezone
	 */
	public String getTimezone() {
		return timezone;
	}

	/**
	 *
	 * @param timezone
	 *            The timezone
	 */
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	/**
	 *
	 * @return The gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 *
	 * @param gender
	 *            The gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
