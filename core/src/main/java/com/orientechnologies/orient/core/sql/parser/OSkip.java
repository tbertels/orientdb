/* Generated By:JJTree: Do not edit this line. OSkip.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.orientechnologies.orient.core.sql.parser;

import java.util.Map;

public class OSkip extends SimpleNode {

  protected OInteger        num;

  protected OInputParameter inputParam;

  protected Object          inputFinalValue;

  public OSkip(int id) {
    super(id);
  }

  public OSkip(OrientSql p, int id) {
    super(p, id);
  }

  /** Accept the visitor. **/
  public Object jjtAccept(OrientSqlVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }



  public void toString(Map<Object, Object> params, StringBuilder builder) {
    if (num == null && inputParam == null) {
      return;
    }
    builder.append(" SKIP ");
    if (num != null) {
      num.toString(params, builder);
    } else {
      inputParam.toString(params, builder);
    }
  }
}
/* JavaCC - OriginalChecksum=8e13ca184705a8fc1b5939ecefe56a60 (do not edit this line) */