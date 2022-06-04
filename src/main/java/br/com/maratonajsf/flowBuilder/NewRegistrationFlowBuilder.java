package br.com.maratonajsf.flowBuilder;

import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;
import java.io.Serializable;

public class NewRegistrationFlowBuilder implements Serializable {
    @Produces
    @FlowDefinition
    public Flow defineFlow(@FlowBuilderParameter FlowBuilder flowBuilder) {
        String flowId = "newRegistration";
        flowBuilder.id("", flowId);
//        flowBuilder.viewNode(flowId, "/" +  flowId + "/" + flowId + ".xhtml").markAsStartNode();
        flowBuilder.viewNode(flowId, "/newRegistration/newRegistration.xhtml").markAsStartNode();
        flowBuilder.viewNode(flowId, "/newRegistration/newRegistration2.xhtml").markAsStartNode();
        flowBuilder.viewNode(flowId, "/newRegistration/newRegistration3.xhtml").markAsStartNode();
        flowBuilder.switchNode("newRegistrationPage2")
                .defaultOutcome(flowId)
                .switchCase()
                .condition("#{not empty testeFlowBuilderBean.nome and not empty testeFlowBuilderBean.sobrenome}")
                .fromOutcome("newRegistration2");
        flowBuilder.flowCallNode("callNewPendencies")
                .flowReference("", "newPendencies")
                .outboundParameter("userName", "#{testeFlowBuilderBean.nome}")
                .outboundParameter("userSurname", "#{testeFlowBuilderBean.sobrenome}");
        flowBuilder.returnNode("exitToInicio").fromOutcome("/inicioflow.xhtml");
        flowBuilder.returnNode("exitToIndex").fromOutcome("/index.xhtml");
        flowBuilder.finalizer("#{testeFlowBuilderBean.salvar()}");
        return flowBuilder.getFlow();
    }
}
