package in.strollup.fb.contract;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Delivery {

	@SerializedName("mids")
	@Expose
	private List<String> mids = new ArrayList<String>();
	@SerializedName("watermark")
	@Expose
	private Long watermark;
	@SerializedName("seq")
	@Expose
	private Long seq;

	/**
	 *
	 * @return The mids
	 */
	public List<String> getMids() {
		return mids;
	}

	/**
	 *
	 * @param mids
	 *            The mids
	 */
	public void setMids(List<String> mids) {
		this.mids = mids;
	}

	/**
	 *
	 * @return The watermark
	 */
	public Long getWatermark() {
		return watermark;
	}

	/**
	 *
	 * @param watermark
	 *            The watermark
	 */
	public void setWatermark(Long watermark) {
		this.watermark = watermark;
	}

	/**
	 *
	 * @return The seq
	 */
	public Long getSeq() {
		return seq;
	}

	/**
	 *
	 * @param seq
	 *            The seq
	 */
	public void setSeq(Long seq) {
		this.seq = seq;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(mids).append(watermark).append(seq).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Delivery) == false) {
			return false;
		}
		Delivery rhs = ((Delivery) other);
		return new EqualsBuilder().append(mids, rhs.mids).append(watermark, rhs.watermark).append(seq, rhs.seq)
				.isEquals();
	}

}