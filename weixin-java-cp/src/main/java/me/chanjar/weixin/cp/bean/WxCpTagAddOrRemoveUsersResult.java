package me.chanjar.weixin.cp.bean;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.base.Splitter;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import me.chanjar.weixin.cp.util.json.WxCpGsonBuilder;

/**
 * 为标签添加或移除用户结果对象类.
 * Created by Binary Wang on 2017-6-22.
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@Data
public class WxCpTagAddOrRemoveUsersResult implements Serializable {
  private static final long serialVersionUID = 1420065684270213578L;

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
  }

  public static WxCpTagAddOrRemoveUsersResult fromJson(String json) {
    return WxCpGsonBuilder.INSTANCE.create().fromJson(json, WxCpTagAddOrRemoveUsersResult.class);
  }

  @SerializedName("errcode")
  private Integer errCode;

  @SerializedName("errmsg")
  private String errMsg;

  @SerializedName("invalidlist")
  private String invalidUsers;

  @SerializedName("invalidparty")
  private String[] invalidParty;

  public List<String> getInvalidUserList() {
    return this.content2List(this.invalidUsers);
  }

  private List<String> content2List(String content) {
    if (StringUtils.isBlank(content)) {
      return Collections.emptyList();
    }

    return Splitter.on("|").splitToList(content);
  }

}
