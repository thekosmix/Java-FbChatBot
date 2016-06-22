package in.strollup.fb.contract;

import java.util.List;
import javax.annotation.Generated;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Payload {

	@SerializedName("template_type")
	@Expose
	private String templateType;
	@SerializedName("text")
	@Expose
	private String text;
	@SerializedName("elements")
	@Expose
	private List<Element> elements;
	@SerializedName("buttons")
	@Expose
	private List<Button> buttons;

	public List<Button> getButtons() {
		return buttons;
	}

	public void setButtons(List<Button> buttons) {
		this.buttons = buttons;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	/**
	 * 
	 * @return The templateType
	 */
	public String getTemplateType() {
		return templateType;
	}

	/**
	 * 
	 * @param templateType
	 *            The template_type
	 */
	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}

	/**
	 * 
	 * @return The elements
	 */
	public List<Element> getElements() {
		return elements;
	}

	/**
	 * 
	 * @param elements
	 *            The elements
	 */
	public void setElements(List<Element> elements) {
		this.elements = elements;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(templateType).append(elements).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Payload) == false) {
			return false;
		}
		Payload rhs = ((Payload) other);
		return new EqualsBuilder().append(templateType, rhs.templateType).append(elements, rhs.elements).isEquals();
	}

}
