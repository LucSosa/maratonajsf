package br.com.maratonajsf.flowBuilder;

import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;
import java.io.Serializable;

public class NewPendenciesFlowBuilder implements Serializable {
    @Produces
    @FlowDefinition
    public Flow defineFlow(@FlowBuilderParameter FlowBuilder flowBuilder){
        String flowId = "newPendencies";
        flowBuilder.id("", flowId);
        flowBuilder.viewNode(flowId, "newpendencies/newpendencies.xhtml").markAsStartNode();
        flowBuilder.returnNode("proceedToNewRegistration3")
                .fromOutcome("/newregistration/newregistration3.xhtml");
        flowBuilder.returnNode("exitToNewInicio")
                .fromOutcome("/newregistration/newregistration.xhtml");
        flowBuilder.inboundParameter("userName", "#{testeFlowNestedBuilderBean.userName}");
        flowBuilder.inboundParameter("userName", "#{testeFlowNestedBuilderBean.userSurname}");
        return flowBuilder.getFlow();
    }
}
