package com.orientechnologies.orient.core.sql.executor;

import com.orientechnologies.orient.core.command.OBasicCommandContext;
import com.orientechnologies.orient.core.command.OCommandContext;
import com.orientechnologies.orient.core.exception.OCommandExecutionException;
import com.orientechnologies.orient.core.sql.parser.OSimpleExecStatement;

import java.util.Collections;
import java.util.List;

/**
 * @author Luigi Dell'Aquila
 */
public class OSingleOpExecutionPlan implements OInternalExecutionPlan {

  private final OSimpleExecStatement statement;
  OCommandContext ctx;

  boolean executed = false;

  public OSingleOpExecutionPlan(OCommandContext ctx, OSimpleExecStatement stm) {
    this.ctx = ctx;
    this.statement = stm;
  }

  @Override public void close() {

  }

  @Override public OTodoResultSet fetchNext(int n) {
    return null;
  }

  public void reset(OCommandContext ctx) {
    executed = false;
  }

  @Override public long getCost() {
    return 0;
  }

  public OTodoResultSet executeInternal(OBasicCommandContext ctx) throws OCommandExecutionException {
    if (executed) {
      throw new OCommandExecutionException("Trying to execute a result-set twice. Please use reset()");
    }
    executed = true;
    OTodoResultSet result = statement.executeSimple(this.ctx);
    if (result instanceof OInternalResultSet) {
      ((OInternalResultSet) result).plan = this;
    }
    return result;
  }

  @Override public List<OExecutionStep> getSteps() {
    return Collections.emptyList();
  }

  @Override public String prettyPrint(int depth, int indent) {
    String spaces = OExecutionStepInternal.getIndent(depth, indent);
    StringBuilder result = new StringBuilder();
    result.append(spaces);
    result.append("+ ");
    result.append(statement.toString());
    return result.toString();
  }

  @Override public OResult toResult() {
    return null;
  }
}