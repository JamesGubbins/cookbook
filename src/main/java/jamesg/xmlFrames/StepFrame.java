package jamesg.xmlFrames;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/** XML frame for xml parsing */
@Root
public class StepFrame {
  @Attribute private int no;
  @Attribute private String desc;

  /**
   * Gets no
   *
   * @return value of no
   */
  public int getNo() {
    return no;
  }

  /**
   * Sets no
   *
   * @param no new value
   */
  public void setNo(int no) {
    this.no = no;
  }

  /**
   * Gets desc
   *
   * @return value of desc
   */
  public String getDesc() {
    return desc;
  }

  /**
   * Sets desc
   *
   * @param desc new value
   */
  public void setDesc(String desc) {
    this.desc = desc;
  }
}
