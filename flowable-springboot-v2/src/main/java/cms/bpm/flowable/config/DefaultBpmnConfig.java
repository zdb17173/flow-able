package cms.bpm.flowable.config;

import java.util.HashMap;
import java.util.Map;

/**
 * 默认流程配置
 * @author qiushi
 * @date 2022/10/31
 */
public class DefaultBpmnConfig {

    public static String DEFAULT_TENANT_ID = "default";
    public static Map<String, String> defaultBpm = new HashMap<>();

    public static String step2Bpm =
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<definitions xmlns=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:flowable=\"http://flowable.org/bpmn\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:omgdc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:omgdi=\"http://www.omg.org/spec/DD/20100524/DI\" typeLanguage=\"http://www.w3.org/2001/XMLSchema\" expressionLanguage=\"http://www.w3.org/1999/XPath\" targetNamespace=\"http://www.flowable.org/processdef\" exporter=\"Flowable Open Source Modeler\" exporterVersion=\"6.7.2\">\n" +
            "  <process id=\"step-2\" name=\"step-2\" isExecutable=\"true\" >\n" +
            "    <startEvent id=\"startEvent1\" flowable:formFieldValidation=\"true\"></startEvent>\n" +
            "    <userTask id=\"node1\" name=\"节点1\" flowable:candidateGroups=\"${node1}\" flowable:formFieldValidation=\"true\"></userTask>\n" +
            "    <sequenceFlow id=\"sid-A8E81E5A-5751-44CE-9498-F2C29810ACAF\" sourceRef=\"startEvent1\" targetRef=\"node1\"></sequenceFlow>\n" +
            "    <exclusiveGateway id=\"sid-7498FCFA-0F44-4C69-B41F-DE5086527F4C\"></exclusiveGateway>\n" +
            "    <userTask id=\"node2\" name=\"节点2\" flowable:candidateGroups=\"${node2}\" flowable:formFieldValidation=\"true\"></userTask>\n" +
            "    <exclusiveGateway id=\"sid-6A0433B6-15B9-4117-97C1-EDA68919A61D\"></exclusiveGateway>\n" +
            "    <sequenceFlow id=\"sid-50A72EA8-3B74-4562-AB1A-D1AAAB1E4927\" sourceRef=\"node2\" targetRef=\"sid-6A0433B6-15B9-4117-97C1-EDA68919A61D\"></sequenceFlow>\n" +
            "    <endEvent id=\"sid-D2210D63-246D-4990-AD4C-D5992F8271F8\"></endEvent>\n" +
            "    <endEvent id=\"sid-65968183-2AB2-4F94-BCF0-FBA79043E642\">\n" +
            "      <terminateEventDefinition></terminateEventDefinition>\n" +
            "    </endEvent>\n" +
            "    <sequenceFlow id=\"sid-52E69863-3DE1-4D0B-8A2E-E686CDFA4360\" sourceRef=\"node1\" targetRef=\"sid-7498FCFA-0F44-4C69-B41F-DE5086527F4C\"></sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-1D9A9C1C-0F9A-4FC5-8428-576FE695549B\" sourceRef=\"sid-6A0433B6-15B9-4117-97C1-EDA68919A61D\" targetRef=\"node1\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow== 1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-B9D543DB-A325-4666-88C4-2FE4FC9FB827\" sourceRef=\"sid-7498FCFA-0F44-4C69-B41F-DE5086527F4C\" targetRef=\"sid-65968183-2AB2-4F94-BCF0-FBA79043E642\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow== -2}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-4C630E23-BD98-413F-A599-800679E8F356\" sourceRef=\"sid-7498FCFA-0F44-4C69-B41F-DE5086527F4C\" targetRef=\"sid-D2210D63-246D-4990-AD4C-D5992F8271F8\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow== -1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-1804C17B-A8D9-4320-8C64-03A4C5281DD4\" sourceRef=\"sid-6A0433B6-15B9-4117-97C1-EDA68919A61D\" targetRef=\"sid-D2210D63-246D-4990-AD4C-D5992F8271F8\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow== 0}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-5AFE50C8-F94B-4F94-941B-77BD113D9D85\" sourceRef=\"sid-7498FCFA-0F44-4C69-B41F-DE5086527F4C\" targetRef=\"node2\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow== 0}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "  </process>\n" +
            "  <bpmndi:BPMNDiagram id=\"BPMNDiagram_step-2\">\n" +
            "    <bpmndi:BPMNPlane bpmnElement=\"step-2\" id=\"BPMNPlane_step-2\">\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"startEvent1\" id=\"BPMNShape_startEvent1\">\n" +
            "        <omgdc:Bounds height=\"30.0\" width=\"30.0\" x=\"195.00000000000003\" y=\"195.00000000000003\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"node1\" id=\"BPMNShape_node1\">\n" +
            "        <omgdc:Bounds height=\"80.0\" width=\"100.0\" x=\"300.00000000000006\" y=\"170.00000000000006\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"sid-7498FCFA-0F44-4C69-B41F-DE5086527F4C\" id=\"BPMNShape_sid-7498FCFA-0F44-4C69-B41F-DE5086527F4C\">\n" +
            "        <omgdc:Bounds height=\"40.0\" width=\"40.0\" x=\"445.00000000000006\" y=\"190.00000000000006\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"node2\" id=\"BPMNShape_node2\">\n" +
            "        <omgdc:Bounds height=\"80.0\" width=\"100.0\" x=\"530.0\" y=\"170.00000000000006\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"sid-6A0433B6-15B9-4117-97C1-EDA68919A61D\" id=\"BPMNShape_sid-6A0433B6-15B9-4117-97C1-EDA68919A61D\">\n" +
            "        <omgdc:Bounds height=\"40.0\" width=\"40.0\" x=\"675.0\" y=\"190.00000000000006\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"sid-D2210D63-246D-4990-AD4C-D5992F8271F8\" id=\"BPMNShape_sid-D2210D63-246D-4990-AD4C-D5992F8271F8\">\n" +
            "        <omgdc:Bounds height=\"28.0\" width=\"28.0\" x=\"765.0000000000002\" y=\"196.0000000000001\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"sid-65968183-2AB2-4F94-BCF0-FBA79043E642\" id=\"BPMNShape_sid-65968183-2AB2-4F94-BCF0-FBA79043E642\">\n" +
            "        <omgdc:Bounds height=\"27.999999999999993\" width=\"28.0\" x=\"765.0000000000003\" y=\"38.999997350904614\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-B9D543DB-A325-4666-88C4-2FE4FC9FB827\" id=\"BPMNEdge_sid-B9D543DB-A325-4666-88C4-2FE4FC9FB827\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"14.0\" flowable:targetDockerY=\"13.999999999999996\">\n" +
            "        <omgdi:waypoint x=\"465.5\" y=\"190.50000000000003\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"465.5\" y=\"52.99999735090461\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"765.0000000000003\" y=\"52.99999735090461\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-50A72EA8-3B74-4562-AB1A-D1AAAB1E4927\" id=\"BPMNEdge_sid-50A72EA8-3B74-4562-AB1A-D1AAAB1E4927\" flowable:sourceDockerX=\"50.0\" flowable:sourceDockerY=\"40.0\" flowable:targetDockerX=\"20.5\" flowable:targetDockerY=\"20.5\">\n" +
            "        <omgdi:waypoint x=\"629.949999999998\" y=\"210.21623376623384\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"675.4130434782554\" y=\"210.4130434782609\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-4C630E23-BD98-413F-A599-800679E8F356\" id=\"BPMNEdge_sid-4C630E23-BD98-413F-A599-800679E8F356\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"14.0\" flowable:targetDockerY=\"14.0\">\n" +
            "        <omgdi:waypoint x=\"465.5\" y=\"190.50000000000003\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"465.5\" y=\"112.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"779.0000000000002\" y=\"112.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"779.0000000000002\" y=\"196.0000000000001\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-5AFE50C8-F94B-4F94-941B-77BD113D9D85\" id=\"BPMNEdge_sid-5AFE50C8-F94B-4F94-941B-77BD113D9D85\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"484.5247370727433\" y=\"210.41666666666674\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"530.0\" y=\"210.21812227074244\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-1804C17B-A8D9-4320-8C64-03A4C5281DD4\" id=\"BPMNEdge_sid-1804C17B-A8D9-4320-8C64-03A4C5281DD4\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"14.0\" flowable:targetDockerY=\"14.0\">\n" +
            "        <omgdi:waypoint x=\"714.5526173285198\" y=\"210.38554216867476\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"765.0002432053413\" y=\"210.0835316523575\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-52E69863-3DE1-4D0B-8A2E-E686CDFA4360\" id=\"BPMNEdge_sid-52E69863-3DE1-4D0B-8A2E-E686CDFA4360\" flowable:sourceDockerX=\"50.0\" flowable:sourceDockerY=\"40.0\" flowable:targetDockerX=\"20.5\" flowable:targetDockerY=\"20.5\">\n" +
            "        <omgdi:waypoint x=\"399.9499999999981\" y=\"210.21623376623384\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"445.413043478261\" y=\"210.41304347826096\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-1D9A9C1C-0F9A-4FC5-8428-576FE695549B\" id=\"BPMNEdge_sid-1D9A9C1C-0F9A-4FC5-8428-576FE695549B\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"695.5\" y=\"229.44102746212127\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"695.5\" y=\"316.00000000000006\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"350.00000000000006\" y=\"316.00000000000006\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"350.00000000000006\" y=\"249.95000000000007\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-A8E81E5A-5751-44CE-9498-F2C29810ACAF\" id=\"BPMNEdge_sid-A8E81E5A-5751-44CE-9498-F2C29810ACAF\" flowable:sourceDockerX=\"15.0\" flowable:sourceDockerY=\"15.0\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"224.94999906759475\" y=\"210.00000000000003\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"299.9999999999967\" y=\"210.00000000000003\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "    </bpmndi:BPMNPlane>\n" +
            "  </bpmndi:BPMNDiagram>\n" +
            "</definitions>";

    static String step3Bpm = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<definitions xmlns=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:flowable=\"http://flowable.org/bpmn\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:omgdc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:omgdi=\"http://www.omg.org/spec/DD/20100524/DI\" typeLanguage=\"http://www.w3.org/2001/XMLSchema\" expressionLanguage=\"http://www.w3.org/1999/XPath\" targetNamespace=\"http://www.flowable.org/processdef\" exporter=\"Flowable Open Source Modeler\" exporterVersion=\"6.7.2\">\n" +
            "  <process id=\"step-3\" name=\"step-3\" isExecutable=\"true\" >\n" +
            "    <startEvent id=\"startEvent1\" flowable:formFieldValidation=\"true\"></startEvent>\n" +
            "    <userTask id=\"node1\" name=\"节点1\" flowable:candidateGroups=\"${node1}\" flowable:formFieldValidation=\"true\"></userTask>\n" +
            "    <sequenceFlow id=\"sid-01B1C232-343B-433E-9A59-EF2D5B62C254\" sourceRef=\"startEvent1\" targetRef=\"node1\"></sequenceFlow>\n" +
            "    <exclusiveGateway id=\"sid-2C9E0CFD-E130-486D-AD74-E6240A7B1813\"></exclusiveGateway>\n" +
            "    <userTask id=\"node2\" name=\"节点2\" flowable:candidateGroups=\"${node2}\" flowable:formFieldValidation=\"true\"></userTask>\n" +
            "    <exclusiveGateway id=\"sid-5A509213-A22E-4CCC-87C8-FC53B1969839\"></exclusiveGateway>\n" +
            "    <sequenceFlow id=\"sid-FDD750D4-15E0-4334-BA7E-6CCB8854F357\" sourceRef=\"node2\" targetRef=\"sid-5A509213-A22E-4CCC-87C8-FC53B1969839\"></sequenceFlow>\n" +
            "    <userTask id=\"node3\" name=\"节点3\" flowable:candidateGroups=\"${node3}\" flowable:formFieldValidation=\"true\"></userTask>\n" +
            "    <exclusiveGateway id=\"sid-4206E06F-B440-4209-9459-F3766DCADC51\"></exclusiveGateway>\n" +
            "    <endEvent id=\"sid-C15A8B5B-4938-4B11-BB21-666C188E0B77\"></endEvent>\n" +
            "    <sequenceFlow id=\"sid-74D931FB-5C61-4470-AC09-AC5BCF4C620A\" sourceRef=\"node3\" targetRef=\"sid-4206E06F-B440-4209-9459-F3766DCADC51\"></sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-065677AB-A2BB-4278-9F37-B83C9DC3D2C0\" sourceRef=\"sid-2C9E0CFD-E130-486D-AD74-E6240A7B1813\" targetRef=\"sid-C15A8B5B-4938-4B11-BB21-666C188E0B77\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==-1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-D2627BB4-BD8A-4B78-BF8F-B7E7038B4D1B\" sourceRef=\"node1\" targetRef=\"sid-2C9E0CFD-E130-486D-AD74-E6240A7B1813\"></sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-5FA83261-AB44-4E3C-BBA2-632529DB301F\" sourceRef=\"sid-2C9E0CFD-E130-486D-AD74-E6240A7B1813\" targetRef=\"node2\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==0}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-DAAC0C97-402F-458F-B8CC-67CF144D6259\" sourceRef=\"sid-5A509213-A22E-4CCC-87C8-FC53B1969839\" targetRef=\"node3\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==0}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-EDAB7061-0F6D-4B93-A22B-B90D74E6993D\" sourceRef=\"sid-4206E06F-B440-4209-9459-F3766DCADC51\" targetRef=\"sid-C15A8B5B-4938-4B11-BB21-666C188E0B77\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==0}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-FFCBE77F-883F-42BA-A5F5-C4211F1F1CD3\" sourceRef=\"sid-5A509213-A22E-4CCC-87C8-FC53B1969839\" targetRef=\"sid-C15A8B5B-4938-4B11-BB21-666C188E0B77\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==-1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-44AC7F43-30B2-4EC3-A58A-53F8C9E3732E\" sourceRef=\"sid-5A509213-A22E-4CCC-87C8-FC53B1969839\" targetRef=\"node1\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-CD442A57-F670-414C-9C40-041D87FDF071\" sourceRef=\"sid-4206E06F-B440-4209-9459-F3766DCADC51\" targetRef=\"node2\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==2}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-43DA85D7-B9E2-4FAA-8577-BCC3D5DB0593\" sourceRef=\"sid-4206E06F-B440-4209-9459-F3766DCADC51\" targetRef=\"node1\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <endEvent id=\"sid-2CBE6247-DFB8-4B0A-A970-127A390A7BF1\">\n" +
            "      <terminateEventDefinition></terminateEventDefinition>\n" +
            "    </endEvent>\n" +
            "    <sequenceFlow id=\"sid-7D08DFF3-AD7F-4CD0-A680-CDA4F987911C\" sourceRef=\"sid-2C9E0CFD-E130-486D-AD74-E6240A7B1813\" targetRef=\"sid-2CBE6247-DFB8-4B0A-A970-127A390A7BF1\"></sequenceFlow>\n" +
            "  </process>\n" +
            "  <bpmndi:BPMNDiagram id=\"BPMNDiagram_step-3\">\n" +
            "    <bpmndi:BPMNPlane bpmnElement=\"step-3\" id=\"BPMNPlane_step-3\">\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"startEvent1\" id=\"BPMNShape_startEvent1\">\n" +
            "        <omgdc:Bounds height=\"30.0\" width=\"30.0\" x=\"180.0\" y=\"338.0000026490954\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"node1\" id=\"BPMNShape_node1\">\n" +
            "        <omgdc:Bounds height=\"80.0\" width=\"100.0\" x=\"285.0000000000001\" y=\"313.0000026490954\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"sid-2C9E0CFD-E130-486D-AD74-E6240A7B1813\" id=\"BPMNShape_sid-2C9E0CFD-E130-486D-AD74-E6240A7B1813\">\n" +
            "        <omgdc:Bounds height=\"40.0\" width=\"40.0\" x=\"435.0\" y=\"333.0000026490954\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"node2\" id=\"BPMNShape_node2\">\n" +
            "        <omgdc:Bounds height=\"80.0\" width=\"100.0\" x=\"534.0\" y=\"313.0000026490954\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"sid-5A509213-A22E-4CCC-87C8-FC53B1969839\" id=\"BPMNShape_sid-5A509213-A22E-4CCC-87C8-FC53B1969839\">\n" +
            "        <omgdc:Bounds height=\"40.0\" width=\"40.0\" x=\"679.0\" y=\"333.0000026490954\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"node3\" id=\"BPMNShape_node3\">\n" +
            "        <omgdc:Bounds height=\"80.0\" width=\"100.0\" x=\"764.0\" y=\"313.0000026490954\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"sid-4206E06F-B440-4209-9459-F3766DCADC51\" id=\"BPMNShape_sid-4206E06F-B440-4209-9459-F3766DCADC51\">\n" +
            "        <omgdc:Bounds height=\"40.0\" width=\"40.0\" x=\"909.0\" y=\"333.0000026490954\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"sid-C15A8B5B-4938-4B11-BB21-666C188E0B77\" id=\"BPMNShape_sid-C15A8B5B-4938-4B11-BB21-666C188E0B77\">\n" +
            "        <omgdc:Bounds height=\"28.0\" width=\"28.0\" x=\"1005.0\" y=\"339.0000026490954\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"sid-2CBE6247-DFB8-4B0A-A970-127A390A7BF1\" id=\"BPMNShape_sid-2CBE6247-DFB8-4B0A-A970-127A390A7BF1\">\n" +
            "        <omgdc:Bounds height=\"28.0\" width=\"27.999999999999886\" x=\"1005.0000000000001\" y=\"160.0\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-43DA85D7-B9E2-4FAA-8577-BCC3D5DB0593\" id=\"BPMNEdge_sid-43DA85D7-B9E2-4FAA-8577-BCC3D5DB0593\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"929.5\" y=\"372.4439522020967\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"929.5\" y=\"510.00000264909545\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"335.0000000000001\" y=\"510.00000264909545\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"335.0000000000001\" y=\"392.9500026490954\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-44AC7F43-30B2-4EC3-A58A-53F8C9E3732E\" id=\"BPMNEdge_sid-44AC7F43-30B2-4EC3-A58A-53F8C9E3732E\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"699.5\" y=\"372.4403931156269\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"699.5\" y=\"452.0000026490954\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"335.0000000000001\" y=\"452.0000026490954\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"335.0000000000001\" y=\"392.9500026490954\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-74D931FB-5C61-4470-AC09-AC5BCF4C620A\" id=\"BPMNEdge_sid-74D931FB-5C61-4470-AC09-AC5BCF4C620A\" flowable:sourceDockerX=\"50.0\" flowable:sourceDockerY=\"40.0\" flowable:targetDockerX=\"20.5\" flowable:targetDockerY=\"20.5\">\n" +
            "        <omgdi:waypoint x=\"863.9499999999846\" y=\"353.2162364153291\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"909.413043478261\" y=\"353.4130461273563\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-FFCBE77F-883F-42BA-A5F5-C4211F1F1CD3\" id=\"BPMNEdge_sid-FFCBE77F-883F-42BA-A5F5-C4211F1F1CD3\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"14.0\" flowable:targetDockerY=\"14.0\">\n" +
            "        <omgdi:waypoint x=\"699.5\" y=\"333.5000026490954\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"699.5\" y=\"268.0000026490954\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1019.0\" y=\"268.0000026490954\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1019.0\" y=\"339.0000026490954\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-065677AB-A2BB-4278-9F37-B83C9DC3D2C0\" id=\"BPMNEdge_sid-065677AB-A2BB-4278-9F37-B83C9DC3D2C0\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"14.0\" flowable:targetDockerY=\"14.0\">\n" +
            "        <omgdi:waypoint x=\"455.5\" y=\"333.50000264909545\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"455.5\" y=\"225.0000026490954\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1019.0\" y=\"225.0000026490954\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1019.0\" y=\"339.0000026490954\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-DAAC0C97-402F-458F-B8CC-67CF144D6259\" id=\"BPMNEdge_sid-DAAC0C97-402F-458F-B8CC-67CF144D6259\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"718.5247370727355\" y=\"353.4166693157621\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"764.0\" y=\"353.21812491983775\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-FDD750D4-15E0-4334-BA7E-6CCB8854F357\" id=\"BPMNEdge_sid-FDD750D4-15E0-4334-BA7E-6CCB8854F357\" flowable:sourceDockerX=\"50.0\" flowable:sourceDockerY=\"40.0\" flowable:targetDockerX=\"20.5\" flowable:targetDockerY=\"20.5\">\n" +
            "        <omgdi:waypoint x=\"633.9499999999846\" y=\"353.2162364153291\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"679.413043478261\" y=\"353.4130461273563\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-01B1C232-343B-433E-9A59-EF2D5B62C254\" id=\"BPMNEdge_sid-01B1C232-343B-433E-9A59-EF2D5B62C254\" flowable:sourceDockerX=\"15.0\" flowable:sourceDockerY=\"15.0\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"209.94999906759472\" y=\"353.0000026490954\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"284.9999999998887\" y=\"353.0000026490954\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-CD442A57-F670-414C-9C40-041D87FDF071\" id=\"BPMNEdge_sid-CD442A57-F670-414C-9C40-041D87FDF071\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"929.5\" y=\"372.44311674793266\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"929.5\" y=\"491.00000264909545\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"584.0\" y=\"491.00000264909545\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"584.0\" y=\"392.9500026490954\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-5FA83261-AB44-4E3C-BBA2-632529DB301F\" id=\"BPMNEdge_sid-5FA83261-AB44-4E3C-BBA2-632529DB301F\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"474.5165690866322\" y=\"353.42578389909534\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"533.9999999999984\" y=\"353.194360625749\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-7D08DFF3-AD7F-4CD0-A680-CDA4F987911C\" id=\"BPMNEdge_sid-7D08DFF3-AD7F-4CD0-A680-CDA4F987911C\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"13.999999999999943\" flowable:targetDockerY=\"13.999999999999998\">\n" +
            "        <omgdi:waypoint x=\"455.5\" y=\"333.5000026490954\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"455.5\" y=\"174.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1005.0000000000001\" y=\"174.0\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-EDAB7061-0F6D-4B93-A22B-B90D74E6993D\" id=\"BPMNEdge_sid-EDAB7061-0F6D-4B93-A22B-B90D74E6993D\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"14.0\" flowable:targetDockerY=\"14.0\">\n" +
            "        <omgdi:waypoint x=\"948.5457070706977\" y=\"353.3932610760617\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1005.000211312628\" y=\"353.07793443553214\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-D2627BB4-BD8A-4B78-BF8F-B7E7038B4D1B\" id=\"BPMNEdge_sid-D2627BB4-BD8A-4B78-BF8F-B7E7038B4D1B\" flowable:sourceDockerX=\"50.0\" flowable:sourceDockerY=\"40.0\" flowable:targetDockerX=\"20.5\" flowable:targetDockerY=\"20.5\">\n" +
            "        <omgdi:waypoint x=\"384.9499999999954\" y=\"353.20726405988376\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"435.4166666666667\" y=\"353.4166693157621\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "    </bpmndi:BPMNPlane>\n" +
            "  </bpmndi:BPMNDiagram>\n" +
            "</definitions>";

    static String step4Bpm = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<definitions xmlns=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:flowable=\"http://flowable.org/bpmn\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:omgdc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:omgdi=\"http://www.omg.org/spec/DD/20100524/DI\" typeLanguage=\"http://www.w3.org/2001/XMLSchema\" expressionLanguage=\"http://www.w3.org/1999/XPath\" targetNamespace=\"http://www.flowable.org/processdef\" exporter=\"Flowable Open Source Modeler\" exporterVersion=\"6.7.2\">\n" +
            "  <process id=\"step-4\" name=\"step-4\" isExecutable=\"true\">\n" +
            "    <startEvent id=\"startEvent1\" flowable:formFieldValidation=\"true\"></startEvent>\n" +
            "    <userTask id=\"node1\" name=\"节点1\" flowable:candidateGroups=\"${node1}\" flowable:formFieldValidation=\"true\"></userTask>\n" +
            "    <sequenceFlow id=\"sid-5761E2DB-3925-4A2B-ACC7-C2D08562CCF9\" sourceRef=\"startEvent1\" targetRef=\"node1\"></sequenceFlow>\n" +
            "    <exclusiveGateway id=\"sid-995BD46D-C3B5-4CEE-9243-6AE5E0431C8F\"></exclusiveGateway>\n" +
            "    <sequenceFlow id=\"sid-FC369FDD-64C1-4F28-BBDB-D65868B80D66\" sourceRef=\"node1\" targetRef=\"sid-995BD46D-C3B5-4CEE-9243-6AE5E0431C8F\"></sequenceFlow>\n" +
            "    <userTask id=\"node2\" name=\"节点2\" flowable:candidateGroups=\"${node2}\" flowable:formFieldValidation=\"true\"></userTask>\n" +
            "    <exclusiveGateway id=\"sid-1F9AB326-4D5D-4650-9DAE-EA33320122F9\"></exclusiveGateway>\n" +
            "    <sequenceFlow id=\"sid-DF38518C-F981-4990-9542-6427B6C3D03C\" sourceRef=\"node2\" targetRef=\"sid-1F9AB326-4D5D-4650-9DAE-EA33320122F9\"></sequenceFlow>\n" +
            "    <userTask id=\"node3\" name=\"节点3\" flowable:candidateGroups=\"${node3}\" flowable:formFieldValidation=\"true\"></userTask>\n" +
            "    <exclusiveGateway id=\"sid-17E8C9E9-9E8C-4152-902D-4804D32D3E6F\"></exclusiveGateway>\n" +
            "    <sequenceFlow id=\"sid-4EBDE3E1-A45C-4C50-ABD4-B8C3C34C8895\" sourceRef=\"node3\" targetRef=\"sid-17E8C9E9-9E8C-4152-902D-4804D32D3E6F\"></sequenceFlow>\n" +
            "    <userTask id=\"node4\" name=\"节点4\" flowable:candidateGroups=\"${node4}\" flowable:formFieldValidation=\"true\"></userTask>\n" +
            "    <exclusiveGateway id=\"sid-A6D6B627-4721-4A8A-A17C-C75C7904474B\"></exclusiveGateway>\n" +
            "    <sequenceFlow id=\"sid-1298257F-3FA4-492C-BE84-61E95A335E17\" sourceRef=\"node4\" targetRef=\"sid-A6D6B627-4721-4A8A-A17C-C75C7904474B\"></sequenceFlow>\n" +
            "    <endEvent id=\"sid-3F53EC81-7D2F-4F3C-BD55-51F6DE65E901\"></endEvent>\n" +
            "    <sequenceFlow id=\"sid-F1027BBA-7A59-4B5A-A0AA-D33B53DE58B8\" sourceRef=\"sid-17E8C9E9-9E8C-4152-902D-4804D32D3E6F\" targetRef=\"node1\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow== 1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-2DD20D23-275D-45B3-BDC1-95C525AC50C2\" sourceRef=\"sid-17E8C9E9-9E8C-4152-902D-4804D32D3E6F\" targetRef=\"node2\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow== 2}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-3A6CF67F-5564-414E-A9C0-687289CD881B\" sourceRef=\"sid-1F9AB326-4D5D-4650-9DAE-EA33320122F9\" targetRef=\"node1\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow== 1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-26607043-6993-4E83-8510-FE40CF7CFA78\" sourceRef=\"sid-995BD46D-C3B5-4CEE-9243-6AE5E0431C8F\" targetRef=\"node2\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow== 0}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-87F05DEF-5C8D-4614-B4AC-4108345B8B69\" sourceRef=\"sid-1F9AB326-4D5D-4650-9DAE-EA33320122F9\" targetRef=\"node3\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow== 0}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-50D6ADC9-3D8F-4F59-999C-A345B4C055A9\" sourceRef=\"sid-17E8C9E9-9E8C-4152-902D-4804D32D3E6F\" targetRef=\"node4\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow== 0}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-7267A4BC-6934-4E10-813E-C87DE528907B\" sourceRef=\"sid-A6D6B627-4721-4A8A-A17C-C75C7904474B\" targetRef=\"sid-3F53EC81-7D2F-4F3C-BD55-51F6DE65E901\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow== 0}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-0DF23648-78B9-4762-9D66-05A5931D9A04\" sourceRef=\"sid-17E8C9E9-9E8C-4152-902D-4804D32D3E6F\" targetRef=\"sid-3F53EC81-7D2F-4F3C-BD55-51F6DE65E901\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow== -1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-9BD376F7-B707-439E-B1FF-4FC88ED0C5FA\" sourceRef=\"sid-1F9AB326-4D5D-4650-9DAE-EA33320122F9\" targetRef=\"sid-3F53EC81-7D2F-4F3C-BD55-51F6DE65E901\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow== -1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-ADAC8FD7-451D-4E6F-98EC-D0884036BDBD\" sourceRef=\"sid-995BD46D-C3B5-4CEE-9243-6AE5E0431C8F\" targetRef=\"sid-3F53EC81-7D2F-4F3C-BD55-51F6DE65E901\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow== -1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-AE83F3B0-B6E2-4C83-A52A-65D126AB66C2\" sourceRef=\"sid-A6D6B627-4721-4A8A-A17C-C75C7904474B\" targetRef=\"node1\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow== 1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-CEC584C3-F33C-435C-B01E-6D2BF98BC572\" sourceRef=\"sid-A6D6B627-4721-4A8A-A17C-C75C7904474B\" targetRef=\"node2\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow== 2}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-6B5DE429-AFEC-481E-A523-C90944637B9D\" sourceRef=\"sid-A6D6B627-4721-4A8A-A17C-C75C7904474B\" targetRef=\"node3\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow== 3}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "  </process>\n" +
            "  <bpmndi:BPMNDiagram id=\"BPMNDiagram_step-4\">\n" +
            "    <bpmndi:BPMNPlane bpmnElement=\"step-4\" id=\"BPMNPlane_step-4\">\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"startEvent1\" id=\"BPMNShape_startEvent1\">\n" +
            "        <omgdc:Bounds height=\"30.0\" width=\"30.0\" x=\"90.00000000000001\" y=\"219.9768524169922\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"node1\" id=\"BPMNShape_node1\">\n" +
            "        <omgdc:Bounds height=\"80.0\" width=\"100.0\" x=\"165.0\" y=\"194.9768524169922\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"sid-995BD46D-C3B5-4CEE-9243-6AE5E0431C8F\" id=\"BPMNShape_sid-995BD46D-C3B5-4CEE-9243-6AE5E0431C8F\">\n" +
            "        <omgdc:Bounds height=\"40.0\" width=\"40.0\" x=\"315.00000000000006\" y=\"214.97685241699224\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"node2\" id=\"BPMNShape_node2\">\n" +
            "        <omgdc:Bounds height=\"80.0\" width=\"100.0\" x=\"390.00000000000006\" y=\"300.00000000000006\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"sid-1F9AB326-4D5D-4650-9DAE-EA33320122F9\" id=\"BPMNShape_sid-1F9AB326-4D5D-4650-9DAE-EA33320122F9\">\n" +
            "        <omgdc:Bounds height=\"40.0\" width=\"40.0\" x=\"540.0000000000001\" y=\"320.0000000000001\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"node3\" id=\"BPMNShape_node3\">\n" +
            "        <omgdc:Bounds height=\"80.0\" width=\"100.0\" x=\"625.0000000000001\" y=\"390.00000000000006\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"sid-17E8C9E9-9E8C-4152-902D-4804D32D3E6F\" id=\"BPMNShape_sid-17E8C9E9-9E8C-4152-902D-4804D32D3E6F\">\n" +
            "        <omgdc:Bounds height=\"40.0\" width=\"40.0\" x=\"770.0000000000001\" y=\"410.0000000000001\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"node4\" id=\"BPMNShape_node4\">\n" +
            "        <omgdc:Bounds height=\"79.99999999999994\" width=\"100.0\" x=\"855.0000000000001\" y=\"495.00000000000006\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"sid-A6D6B627-4721-4A8A-A17C-C75C7904474B\" id=\"BPMNShape_sid-A6D6B627-4721-4A8A-A17C-C75C7904474B\">\n" +
            "        <omgdc:Bounds height=\"40.0\" width=\"40.0\" x=\"1000.0000000000002\" y=\"515.0000000000001\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"sid-3F53EC81-7D2F-4F3C-BD55-51F6DE65E901\" id=\"BPMNShape_sid-3F53EC81-7D2F-4F3C-BD55-51F6DE65E901\">\n" +
            "        <omgdc:Bounds height=\"28.0\" width=\"28.0\" x=\"1136.0000000000002\" y=\"521.0000000000002\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-9BD376F7-B707-439E-B1FF-4FC88ED0C5FA\" id=\"BPMNEdge_sid-9BD376F7-B707-439E-B1FF-4FC88ED0C5FA\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"14.0\" flowable:targetDockerY=\"14.0\">\n" +
            "        <omgdi:waypoint x=\"560.5\" y=\"320.5000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"560.5000000000001\" y=\"236.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1150.0000000000002\" y=\"236.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1150.0000000000002\" y=\"521.0000000000002\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-F1027BBA-7A59-4B5A-A0AA-D33B53DE58B8\" id=\"BPMNEdge_sid-F1027BBA-7A59-4B5A-A0AA-D33B53DE58B8\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"790.5000000000001\" y=\"449.44285444947224\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"790.5000000000001\" y=\"563.0000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"215.0\" y=\"563.0000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"215.0\" y=\"274.92685241699223\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-ADAC8FD7-451D-4E6F-98EC-D0884036BDBD\" id=\"BPMNEdge_sid-ADAC8FD7-451D-4E6F-98EC-D0884036BDBD\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"14.0\" flowable:targetDockerY=\"14.0\">\n" +
            "        <omgdi:waypoint x=\"335.50000000000006\" y=\"215.47685241699227\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"335.5000000000001\" y=\"171.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1150.0000000000005\" y=\"171.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1150.0000000000002\" y=\"521.0000000000002\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-AE83F3B0-B6E2-4C83-A52A-65D126AB66C2\" id=\"BPMNEdge_sid-AE83F3B0-B6E2-4C83-A52A-65D126AB66C2\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"1020.5000000000002\" y=\"554.4423134139244\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1020.5000000000002\" y=\"658.6666870117188\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"215.0\" y=\"658.6666870117188\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"215.0\" y=\"274.92685241699223\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-CEC584C3-F33C-435C-B01E-6D2BF98BC572\" id=\"BPMNEdge_sid-CEC584C3-F33C-435C-B01E-6D2BF98BC572\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"1020.5000000000002\" y=\"554.4408247274372\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1020.5000000000002\" y=\"638.6666870117188\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"440.0000000000001\" y=\"638.6666870117188\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"440.00000000000006\" y=\"379.95000000000005\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-4EBDE3E1-A45C-4C50-ABD4-B8C3C34C8895\" id=\"BPMNEdge_sid-4EBDE3E1-A45C-4C50-ABD4-B8C3C34C8895\" flowable:sourceDockerX=\"50.0\" flowable:sourceDockerY=\"40.0\" flowable:targetDockerX=\"20.5\" flowable:targetDockerY=\"20.5\">\n" +
            "        <omgdi:waypoint x=\"724.949999999993\" y=\"430.21623376623387\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"770.4130434782513\" y=\"430.41304347826093\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-5761E2DB-3925-4A2B-ACC7-C2D08562CCF9\" id=\"BPMNEdge_sid-5761E2DB-3925-4A2B-ACC7-C2D08562CCF9\" flowable:sourceDockerX=\"15.0\" flowable:sourceDockerY=\"15.0\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"119.94999848995761\" y=\"234.9768524169922\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"165.0\" y=\"234.9768524169922\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-26607043-6993-4E83-8510-FE40CF7CFA78\" id=\"BPMNEdge_sid-26607043-6993-4E83-8510-FE40CF7CFA78\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"354.44094168260045\" y=\"235.47685241699224\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"440.00000000000006\" y=\"235.47685241699224\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"440.00000000000006\" y=\"300.00000000000006\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-6B5DE429-AFEC-481E-A523-C90944637B9D\" id=\"BPMNEdge_sid-6B5DE429-AFEC-481E-A523-C90944637B9D\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"1020.5000000000002\" y=\"554.437945292621\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1020.5000000000002\" y=\"614.0000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"675.0000000000001\" y=\"614.0000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"675.0000000000001\" y=\"469.95000000000005\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-87F05DEF-5C8D-4614-B4AC-4108345B8B69\" id=\"BPMNEdge_sid-87F05DEF-5C8D-4614-B4AC-4108345B8B69\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"579.4417321116929\" y=\"340.5000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"675.0000000000001\" y=\"340.5000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"675.0000000000001\" y=\"390.00000000000006\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-3A6CF67F-5564-414E-A9C0-687289CD881B\" id=\"BPMNEdge_sid-3A6CF67F-5564-414E-A9C0-687289CD881B\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"560.5\" y=\"359.43852905569025\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"560.5000000000002\" y=\"423.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"215.0\" y=\"423.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"215.0\" y=\"274.92685241699223\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-DF38518C-F981-4990-9542-6427B6C3D03C\" id=\"BPMNEdge_sid-DF38518C-F981-4990-9542-6427B6C3D03C\" flowable:sourceDockerX=\"50.0\" flowable:sourceDockerY=\"40.0\" flowable:targetDockerX=\"20.5\" flowable:targetDockerY=\"20.5\">\n" +
            "        <omgdi:waypoint x=\"489.95000000000005\" y=\"340.20726141078853\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"540.4166666666667\" y=\"340.4166666666668\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-FC369FDD-64C1-4F28-BBDB-D65868B80D66\" id=\"BPMNEdge_sid-FC369FDD-64C1-4F28-BBDB-D65868B80D66\" flowable:sourceDockerX=\"50.0\" flowable:sourceDockerY=\"40.0\" flowable:targetDockerX=\"20.5\" flowable:targetDockerY=\"20.5\">\n" +
            "        <omgdi:waypoint x=\"264.94999999999385\" y=\"235.18411382778064\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"315.41666666666674\" y=\"235.3935190836589\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-1298257F-3FA4-492C-BE84-61E95A335E17\" id=\"BPMNEdge_sid-1298257F-3FA4-492C-BE84-61E95A335E17\" flowable:sourceDockerX=\"50.0\" flowable:sourceDockerY=\"39.99999999999997\" flowable:targetDockerX=\"20.5\" flowable:targetDockerY=\"20.5\">\n" +
            "        <omgdi:waypoint x=\"954.9499999999734\" y=\"535.2162337662337\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1000.4130434782611\" y=\"535.413043478261\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-2DD20D23-275D-45B3-BDC1-95C525AC50C2\" id=\"BPMNEdge_sid-2DD20D23-275D-45B3-BDC1-95C525AC50C2\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"790.5000000000001\" y=\"449.4397678185747\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"790.5000000000001\" y=\"523.0000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"440.0000000000001\" y=\"523.0000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"440.00000000000006\" y=\"379.95000000000005\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-50D6ADC9-3D8F-4F59-999C-A345B4C055A9\" id=\"BPMNEdge_sid-50D6ADC9-3D8F-4F59-999C-A345B4C055A9\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"39.99999999999997\">\n" +
            "        <omgdi:waypoint x=\"809.4417321115678\" y=\"430.5000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"905.0000000000001\" y=\"430.5000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"905.0000000000001\" y=\"495.00000000000006\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-0DF23648-78B9-4762-9D66-05A5931D9A04\" id=\"BPMNEdge_sid-0DF23648-78B9-4762-9D66-05A5931D9A04\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"14.0\" flowable:targetDockerY=\"14.0\">\n" +
            "        <omgdi:waypoint x=\"790.5000000000001\" y=\"410.5000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"790.5000000000001\" y=\"315.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1150.0000000000002\" y=\"315.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1150.0000000000002\" y=\"521.0000000000002\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-7267A4BC-6934-4E10-813E-C87DE528907B\" id=\"BPMNEdge_sid-7267A4BC-6934-4E10-813E-C87DE528907B\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"14.0\" flowable:targetDockerY=\"14.0\">\n" +
            "        <omgdi:waypoint x=\"1039.5160534469155\" y=\"535.4263565891474\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1136.000099391872\" y=\"535.0538607692777\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "    </bpmndi:BPMNPlane>\n" +
            "  </bpmndi:BPMNDiagram>\n" +
            "</definitions>";

    static String step5Bpm = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<definitions xmlns=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:flowable=\"http://flowable.org/bpmn\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:omgdc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:omgdi=\"http://www.omg.org/spec/DD/20100524/DI\" typeLanguage=\"http://www.w3.org/2001/XMLSchema\" expressionLanguage=\"http://www.w3.org/1999/XPath\" targetNamespace=\"http://www.flowable.org/processdef\" exporter=\"Flowable Open Source Modeler\" exporterVersion=\"6.7.2\">\n" +
            "  <process id=\"step-5\" name=\"step-5\" isExecutable=\"true\">\n" +
            "    <startEvent id=\"startEvent1\" flowable:formFieldValidation=\"true\"></startEvent>\n" +
            "    <userTask id=\"node1\" name=\"节点1\" flowable:candidateGroups=\"${node1}\" flowable:formFieldValidation=\"true\"></userTask>\n" +
            "    <sequenceFlow id=\"sid-A58C471D-8D06-42A0-AEAF-D1BFECA4ED2A\" sourceRef=\"startEvent1\" targetRef=\"node1\"></sequenceFlow>\n" +
            "    <exclusiveGateway id=\"sid-4BAA6850-E311-4EC3-8541-6FFCB2B11FFA\"></exclusiveGateway>\n" +
            "    <userTask id=\"node2\" name=\"节点2\" flowable:candidateGroups=\"${node2}\" flowable:formFieldValidation=\"true\"></userTask>\n" +
            "    <exclusiveGateway id=\"sid-A4361F0E-8BE5-426E-9316-01A25F3300F2\"></exclusiveGateway>\n" +
            "    <sequenceFlow id=\"sid-9F2F601E-7C91-4BC5-B514-ABC2B811E48D\" sourceRef=\"node2\" targetRef=\"sid-A4361F0E-8BE5-426E-9316-01A25F3300F2\"></sequenceFlow>\n" +
            "    <userTask id=\"node3\" name=\"节点3\" flowable:candidateGroups=\"${node3}\" flowable:formFieldValidation=\"true\"></userTask>\n" +
            "    <exclusiveGateway id=\"sid-247DEB58-3C0F-4ED2-8E72-6DA2738EAD93\"></exclusiveGateway>\n" +
            "    <sequenceFlow id=\"sid-F6707305-2488-4FCF-AF96-ABF7F76F14CC\" sourceRef=\"node3\" targetRef=\"sid-247DEB58-3C0F-4ED2-8E72-6DA2738EAD93\"></sequenceFlow>\n" +
            "    <userTask id=\"node4\" name=\"节点4\" flowable:candidateGroups=\"${node4}\" flowable:formFieldValidation=\"true\"></userTask>\n" +
            "    <exclusiveGateway id=\"sid-2744F4E0-E792-4ECB-8D9B-D9D94CCFFEA6\"></exclusiveGateway>\n" +
            "    <sequenceFlow id=\"sid-5E3EA5FA-13F3-4180-B09C-9510FBB9E674\" sourceRef=\"node4\" targetRef=\"sid-2744F4E0-E792-4ECB-8D9B-D9D94CCFFEA6\"></sequenceFlow>\n" +
            "    <userTask id=\"node5\" name=\"节点5\" flowable:candidateGroups=\"${node5}\" flowable:formFieldValidation=\"true\"></userTask>\n" +
            "    <exclusiveGateway id=\"sid-7260F956-3255-48A3-BF9B-FD8FDDDF9053\"></exclusiveGateway>\n" +
            "    <sequenceFlow id=\"sid-0706233D-FFE2-4E32-88D8-3915E5F6E8F0\" sourceRef=\"node5\" targetRef=\"sid-7260F956-3255-48A3-BF9B-FD8FDDDF9053\"></sequenceFlow>\n" +
            "    <endEvent id=\"sid-6F5DCE98-33A5-4DDC-8D3D-59ACF3F631E1\"></endEvent>\n" +
            "    <sequenceFlow id=\"sid-AD6D8F4B-0A66-4429-8459-41FCBF802C22\" sourceRef=\"sid-4BAA6850-E311-4EC3-8541-6FFCB2B11FFA\" targetRef=\"sid-6F5DCE98-33A5-4DDC-8D3D-59ACF3F631E1\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==-1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-4E3BAF6B-12A8-4582-9480-3B178BA11D0D\" sourceRef=\"sid-A4361F0E-8BE5-426E-9316-01A25F3300F2\" targetRef=\"sid-6F5DCE98-33A5-4DDC-8D3D-59ACF3F631E1\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==-1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-32DF9655-0AD3-4649-B647-52168C7FA8CC\" sourceRef=\"sid-247DEB58-3C0F-4ED2-8E72-6DA2738EAD93\" targetRef=\"sid-6F5DCE98-33A5-4DDC-8D3D-59ACF3F631E1\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==-1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-160CBDAF-CB31-49C9-B1B5-593E54F279F6\" sourceRef=\"sid-2744F4E0-E792-4ECB-8D9B-D9D94CCFFEA6\" targetRef=\"sid-6F5DCE98-33A5-4DDC-8D3D-59ACF3F631E1\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==-1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-4F51E3DC-200D-4125-BD94-C6BAFE68F0DC\" sourceRef=\"sid-247DEB58-3C0F-4ED2-8E72-6DA2738EAD93\" targetRef=\"node2\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==2}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-5B4E05FA-5D7D-4C31-966F-6C4FE6438123\" sourceRef=\"sid-247DEB58-3C0F-4ED2-8E72-6DA2738EAD93\" targetRef=\"node1\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-9E092060-4370-48BF-8922-446BB3C6A4D6\" sourceRef=\"sid-2744F4E0-E792-4ECB-8D9B-D9D94CCFFEA6\" targetRef=\"node3\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==3}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-E64CA9B7-B08C-4B62-BE55-904BAF779338\" sourceRef=\"sid-2744F4E0-E792-4ECB-8D9B-D9D94CCFFEA6\" targetRef=\"node2\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==2}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-4A831C08-FB81-4657-B36B-A81D2B079494\" sourceRef=\"sid-2744F4E0-E792-4ECB-8D9B-D9D94CCFFEA6\" targetRef=\"node1\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-A1544712-5400-489E-BA52-49AD99D2A8F6\" sourceRef=\"sid-7260F956-3255-48A3-BF9B-FD8FDDDF9053\" targetRef=\"node1\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-590E2AC5-5707-4ACF-8AB3-9440E175F7A1\" sourceRef=\"sid-7260F956-3255-48A3-BF9B-FD8FDDDF9053\" targetRef=\"node2\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==2}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-15A1CD2B-8EAC-40AA-B501-5221F6F8A7C0\" sourceRef=\"sid-7260F956-3255-48A3-BF9B-FD8FDDDF9053\" targetRef=\"node3\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==3}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-DFB78827-3FB8-49A3-8FE3-5B682B65217D\" sourceRef=\"sid-7260F956-3255-48A3-BF9B-FD8FDDDF9053\" targetRef=\"node4\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==4}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-400DB3B2-2907-490E-B287-F94EDACBB6BA\" sourceRef=\"node1\" targetRef=\"sid-4BAA6850-E311-4EC3-8541-6FFCB2B11FFA\"></sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-E94AC371-0AA1-4300-8A80-7C612CE451BA\" sourceRef=\"sid-4BAA6850-E311-4EC3-8541-6FFCB2B11FFA\" targetRef=\"node2\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==0}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-9CFA8E3B-EEBA-4E4B-A928-E899358B2F74\" sourceRef=\"sid-A4361F0E-8BE5-426E-9316-01A25F3300F2\" targetRef=\"node1\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-2A9241FB-DBE2-4924-9E3E-AF41E6B83B28\" sourceRef=\"sid-247DEB58-3C0F-4ED2-8E72-6DA2738EAD93\" targetRef=\"node4\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==0}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-08C85BFE-5512-4523-90B0-C587A8429949\" sourceRef=\"sid-2744F4E0-E792-4ECB-8D9B-D9D94CCFFEA6\" targetRef=\"node5\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==0}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-CA969EDF-5842-40C3-B9A0-498B33C18CED\" sourceRef=\"sid-7260F956-3255-48A3-BF9B-FD8FDDDF9053\" targetRef=\"sid-6F5DCE98-33A5-4DDC-8D3D-59ACF3F631E1\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==0}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-43BFF1F8-F958-4A3E-B7D3-14D49E65146D\" sourceRef=\"sid-A4361F0E-8BE5-426E-9316-01A25F3300F2\" targetRef=\"node3\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==0}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "  </process>\n" +
            "  <bpmndi:BPMNDiagram id=\"BPMNDiagram_step-5\">\n" +
            "    <bpmndi:BPMNPlane bpmnElement=\"step-5\" id=\"BPMNPlane_step-5\">\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"startEvent1\" id=\"BPMNShape_startEvent1\">\n" +
            "        <omgdc:Bounds height=\"30.0\" width=\"29.999999999999996\" x=\"30.000000000000004\" y=\"85.0\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"node1\" id=\"BPMNShape_node1\">\n" +
            "        <omgdc:Bounds height=\"80.0\" width=\"100.0\" x=\"104.99999999999997\" y=\"60.00000000000001\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"sid-4BAA6850-E311-4EC3-8541-6FFCB2B11FFA\" id=\"BPMNShape_sid-4BAA6850-E311-4EC3-8541-6FFCB2B11FFA\">\n" +
            "        <omgdc:Bounds height=\"40.0\" width=\"40.0\" x=\"250.0\" y=\"80.0\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"node2\" id=\"BPMNShape_node2\">\n" +
            "        <omgdc:Bounds height=\"79.99999999999997\" width=\"100.0\" x=\"300.0000000000001\" y=\"165.00000000000003\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"sid-A4361F0E-8BE5-426E-9316-01A25F3300F2\" id=\"BPMNShape_sid-A4361F0E-8BE5-426E-9316-01A25F3300F2\">\n" +
            "        <omgdc:Bounds height=\"40.0\" width=\"40.0\" x=\"445.0000000000001\" y=\"185.0\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"node3\" id=\"BPMNShape_node3\">\n" +
            "        <omgdc:Bounds height=\"80.0\" width=\"99.99999999999994\" x=\"495.00000000000006\" y=\"285.00000000000006\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"sid-247DEB58-3C0F-4ED2-8E72-6DA2738EAD93\" id=\"BPMNShape_sid-247DEB58-3C0F-4ED2-8E72-6DA2738EAD93\">\n" +
            "        <omgdc:Bounds height=\"40.0\" width=\"40.0\" x=\"640.0\" y=\"305.00000000000006\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"node4\" id=\"BPMNShape_node4\">\n" +
            "        <omgdc:Bounds height=\"80.0\" width=\"100.0\" x=\"690.0000000000001\" y=\"405.0000000000001\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"sid-2744F4E0-E792-4ECB-8D9B-D9D94CCFFEA6\" id=\"BPMNShape_sid-2744F4E0-E792-4ECB-8D9B-D9D94CCFFEA6\">\n" +
            "        <omgdc:Bounds height=\"40.0\" width=\"40.0\" x=\"835.0000000000001\" y=\"425.0000000000001\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"node5\" id=\"BPMNShape_node5\">\n" +
            "        <omgdc:Bounds height=\"80.0\" width=\"100.0\" x=\"885.0000000000001\" y=\"540.0000000000002\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"sid-7260F956-3255-48A3-BF9B-FD8FDDDF9053\" id=\"BPMNShape_sid-7260F956-3255-48A3-BF9B-FD8FDDDF9053\">\n" +
            "        <omgdc:Bounds height=\"40.0\" width=\"40.0\" x=\"1030.0\" y=\"560.0000000000002\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"sid-6F5DCE98-33A5-4DDC-8D3D-59ACF3F631E1\" id=\"BPMNShape_sid-6F5DCE98-33A5-4DDC-8D3D-59ACF3F631E1\">\n" +
            "        <omgdc:Bounds height=\"28.0\" width=\"28.0\" x=\"1115.0\" y=\"566.0000000000002\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-E64CA9B7-B08C-4B62-BE55-904BAF779338\" id=\"BPMNEdge_sid-E64CA9B7-B08C-4B62-BE55-904BAF779338\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"39.999999999999986\">\n" +
            "        <omgdi:waypoint x=\"855.5\" y=\"464.43965611353724\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"855.5000000000002\" y=\"537.0000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"350.0000000000001\" y=\"537.0000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"350.0000000000001\" y=\"244.95000000000002\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-9CFA8E3B-EEBA-4E4B-A928-E899358B2F74\" id=\"BPMNEdge_sid-9CFA8E3B-EEBA-4E4B-A928-E899358B2F74\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"465.5000000000001\" y=\"224.43905889145503\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"465.5000000000001\" y=\"292.00000000000006\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"155.0\" y=\"292.00000000000006\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"154.99999999999997\" y=\"139.95000000000002\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-5B4E05FA-5D7D-4C31-966F-6C4FE6438123\" id=\"BPMNEdge_sid-5B4E05FA-5D7D-4C31-966F-6C4FE6438123\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"660.5\" y=\"344.43954194260493\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"660.5\" y=\"416.00000000000006\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"154.99999999999997\" y=\"416.00000000000006\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"154.99999999999997\" y=\"139.95000000000002\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-AD6D8F4B-0A66-4429-8459-41FCBF802C22\" id=\"BPMNEdge_sid-AD6D8F4B-0A66-4429-8459-41FCBF802C22\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"14.0\" flowable:targetDockerY=\"14.0\">\n" +
            "        <omgdi:waypoint x=\"289.44889645905783\" y=\"100.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1129.0\" y=\"100.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1129.0\" y=\"566.0000000000002\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-160CBDAF-CB31-49C9-B1B5-593E54F279F6\" id=\"BPMNEdge_sid-160CBDAF-CB31-49C9-B1B5-593E54F279F6\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"14.0\" flowable:targetDockerY=\"14.0\">\n" +
            "        <omgdi:waypoint x=\"874.4465369149248\" y=\"445.5000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1129.0\" y=\"445.5000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1129.0\" y=\"566.0000000000002\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-A58C471D-8D06-42A0-AEAF-D1BFECA4ED2A\" id=\"BPMNEdge_sid-A58C471D-8D06-42A0-AEAF-D1BFECA4ED2A\" flowable:sourceDockerX=\"14.999999999999998\" flowable:sourceDockerY=\"15.0\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"59.9499984899576\" y=\"100.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"104.99999999999997\" y=\"100.0\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-590E2AC5-5707-4ACF-8AB3-9440E175F7A1\" id=\"BPMNEdge_sid-590E2AC5-5707-4ACF-8AB3-9440E175F7A1\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"39.999999999999986\">\n" +
            "        <omgdi:waypoint x=\"1050.5\" y=\"599.4405815109345\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1050.5\" y=\"681.0000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"350.0000000000001\" y=\"681.0000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"350.0000000000001\" y=\"244.95000000000002\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-400DB3B2-2907-490E-B287-F94EDACBB6BA\" id=\"BPMNEdge_sid-400DB3B2-2907-490E-B287-F94EDACBB6BA\" flowable:sourceDockerX=\"50.0\" flowable:sourceDockerY=\"40.0\" flowable:targetDockerX=\"20.5\" flowable:targetDockerY=\"20.5\">\n" +
            "        <omgdi:waypoint x=\"204.9499999999993\" y=\"100.21623376623377\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"250.41304347826087\" y=\"100.41304347826087\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-4A831C08-FB81-4657-B36B-A81D2B079494\" id=\"BPMNEdge_sid-4A831C08-FB81-4657-B36B-A81D2B079494\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"855.5\" y=\"464.43954194260505\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"855.5000000000002\" y=\"536.0000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"155.0\" y=\"536.0000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"154.99999999999997\" y=\"139.95000000000002\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-DFB78827-3FB8-49A3-8FE3-5B682B65217D\" id=\"BPMNEdge_sid-DFB78827-3FB8-49A3-8FE3-5B682B65217D\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"1050.5\" y=\"599.4406742125985\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1050.5\" y=\"682.0000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"740.0000000000001\" y=\"682.0000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"740.0000000000001\" y=\"484.95000000000016\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-9E092060-4370-48BF-8922-446BB3C6A4D6\" id=\"BPMNEdge_sid-9E092060-4370-48BF-8922-446BB3C6A4D6\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"49.99999999999997\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"855.5\" y=\"464.4396561135373\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"855.5000000000001\" y=\"537.0000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"545.0\" y=\"537.0000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"545.0\" y=\"364.95000000000005\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-0706233D-FFE2-4E32-88D8-3915E5F6E8F0\" id=\"BPMNEdge_sid-0706233D-FFE2-4E32-88D8-3915E5F6E8F0\" flowable:sourceDockerX=\"50.0\" flowable:sourceDockerY=\"40.0\" flowable:targetDockerX=\"20.5\" flowable:targetDockerY=\"20.5\">\n" +
            "        <omgdi:waypoint x=\"984.9499999999674\" y=\"580.216233766234\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1030.413043478261\" y=\"580.4130434782611\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-CA969EDF-5842-40C3-B9A0-498B33C18CED\" id=\"BPMNEdge_sid-CA969EDF-5842-40C3-B9A0-498B33C18CED\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"14.0\" flowable:targetDockerY=\"14.0\">\n" +
            "        <omgdi:waypoint x=\"1069.5591869398093\" y=\"580.3782051282053\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1115.0002755524704\" y=\"580.0888518842643\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-08C85BFE-5512-4523-90B0-C587A8429949\" id=\"BPMNEdge_sid-08C85BFE-5512-4523-90B0-C587A8429949\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"855.5000000000001\" y=\"464.4429606240715\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"855.5000000000001\" y=\"580.0000000000002\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"885.0000000000001\" y=\"580.0000000000002\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-9F2F601E-7C91-4BC5-B514-ABC2B811E48D\" id=\"BPMNEdge_sid-9F2F601E-7C91-4BC5-B514-ABC2B811E48D\" flowable:sourceDockerX=\"50.0\" flowable:sourceDockerY=\"40.0\" flowable:targetDockerX=\"20.5\" flowable:targetDockerY=\"20.5\">\n" +
            "        <omgdi:waypoint x=\"399.95000000000016\" y=\"205.2162337662338\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"445.413043478261\" y=\"205.41304347826087\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-5E3EA5FA-13F3-4180-B09C-9510FBB9E674\" id=\"BPMNEdge_sid-5E3EA5FA-13F3-4180-B09C-9510FBB9E674\" flowable:sourceDockerX=\"50.0\" flowable:sourceDockerY=\"40.0\" flowable:targetDockerX=\"20.5\" flowable:targetDockerY=\"20.5\">\n" +
            "        <omgdi:waypoint x=\"789.95\" y=\"445.2162337662339\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"835.4130434782359\" y=\"445.4130434782609\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-32DF9655-0AD3-4649-B647-52168C7FA8CC\" id=\"BPMNEdge_sid-32DF9655-0AD3-4649-B647-52168C7FA8CC\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"14.0\" flowable:targetDockerY=\"14.0\">\n" +
            "        <omgdi:waypoint x=\"679.4479780196328\" y=\"325.50000000000006\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1129.0\" y=\"325.50000000000006\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1129.0\" y=\"566.0000000000002\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-15A1CD2B-8EAC-40AA-B501-5221F6F8A7C0\" id=\"BPMNEdge_sid-15A1CD2B-8EAC-40AA-B501-5221F6F8A7C0\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"49.99999999999997\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"1050.5\" y=\"599.4406742125985\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1050.5\" y=\"682.0000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"545.0\" y=\"682.0000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"545.0\" y=\"364.95000000000005\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-2A9241FB-DBE2-4924-9E3E-AF41E6B83B28\" id=\"BPMNEdge_sid-2A9241FB-DBE2-4924-9E3E-AF41E6B83B28\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"660.5\" y=\"344.4420777591974\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"660.5\" y=\"445.0000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"690.0000000000001\" y=\"445.0000000000001\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-F6707305-2488-4FCF-AF96-ABF7F76F14CC\" id=\"BPMNEdge_sid-F6707305-2488-4FCF-AF96-ABF7F76F14CC\" flowable:sourceDockerX=\"50.0\" flowable:sourceDockerY=\"40.0\" flowable:targetDockerX=\"20.5\" flowable:targetDockerY=\"20.5\">\n" +
            "        <omgdi:waypoint x=\"594.9499999999978\" y=\"325.2162337662338\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"640.4130434782609\" y=\"325.41304347826093\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-E94AC371-0AA1-4300-8A80-7C612CE451BA\" id=\"BPMNEdge_sid-E94AC371-0AA1-4300-8A80-7C612CE451BA\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"39.999999999999986\">\n" +
            "        <omgdi:waypoint x=\"270.5\" y=\"119.44094168260035\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"270.5\" y=\"205.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"299.99999999998784\" y=\"205.0\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-43BFF1F8-F958-4A3E-B7D3-14D49E65146D\" id=\"BPMNEdge_sid-43BFF1F8-F958-4A3E-B7D3-14D49E65146D\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"49.99999999999994\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"465.50000000000006\" y=\"224.44207775919733\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"465.5000000000001\" y=\"325.00000000000006\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"495.00000000000006\" y=\"325.00000000000006\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-4E3BAF6B-12A8-4582-9480-3B178BA11D0D\" id=\"BPMNEdge_sid-4E3BAF6B-12A8-4582-9480-3B178BA11D0D\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"14.0\" flowable:targetDockerY=\"14.0\">\n" +
            "        <omgdi:waypoint x=\"484.4485721820375\" y=\"205.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1129.0\" y=\"205.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1129.0\" y=\"566.0000000000002\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-4F51E3DC-200D-4125-BD94-C6BAFE68F0DC\" id=\"BPMNEdge_sid-4F51E3DC-200D-4125-BD94-C6BAFE68F0DC\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"39.999999999999986\">\n" +
            "        <omgdi:waypoint x=\"660.5\" y=\"344.4396561135372\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"660.5\" y=\"417.00000000000006\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"350.0000000000001\" y=\"417.00000000000006\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"350.0000000000001\" y=\"244.95000000000002\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-A1544712-5400-489E-BA52-49AD99D2A8F6\" id=\"BPMNEdge_sid-A1544712-5400-489E-BA52-49AD99D2A8F6\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"1050.5\" y=\"599.4405815109345\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1050.5\" y=\"681.0000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"155.0\" y=\"681.0000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"154.99999999999997\" y=\"139.95000000000002\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "    </bpmndi:BPMNPlane>\n" +
            "  </bpmndi:BPMNDiagram>\n" +
            "</definitions>";

    static String step6Bpm = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<definitions xmlns=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:flowable=\"http://flowable.org/bpmn\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:omgdc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:omgdi=\"http://www.omg.org/spec/DD/20100524/DI\" typeLanguage=\"http://www.w3.org/2001/XMLSchema\" expressionLanguage=\"http://www.w3.org/1999/XPath\" targetNamespace=\"http://www.flowable.org/processdef\" exporter=\"Flowable Open Source Modeler\" exporterVersion=\"6.7.2\">\n" +
            "  <process id=\"step-6\" name=\"step-6\" isExecutable=\"true\">\n" +
            "    <startEvent id=\"startEvent1\" flowable:formFieldValidation=\"true\"></startEvent>\n" +
            "    <userTask id=\"node1\" name=\"节点1\" flowable:candidateGroups=\"${node1}\" flowable:formFieldValidation=\"true\"></userTask>\n" +
            "    <sequenceFlow id=\"sid-73103441-014E-461D-8318-4C74418F380C\" sourceRef=\"startEvent1\" targetRef=\"node1\"></sequenceFlow>\n" +
            "    <exclusiveGateway id=\"sid-243CC0FB-8000-4AF8-93DD-5976B97F04CE\"></exclusiveGateway>\n" +
            "    <sequenceFlow id=\"sid-F687B9A6-7D93-41A8-8077-440251B55C49\" sourceRef=\"node1\" targetRef=\"sid-243CC0FB-8000-4AF8-93DD-5976B97F04CE\"></sequenceFlow>\n" +
            "    <userTask id=\"node2\" name=\"节点2\" flowable:candidateGroups=\"${node2}\" flowable:formFieldValidation=\"true\"></userTask>\n" +
            "    <exclusiveGateway id=\"sid-BB9B61B2-9834-4216-A6D1-21AA568255B6\"></exclusiveGateway>\n" +
            "    <sequenceFlow id=\"sid-0F60858E-0C58-43B0-9A91-C8F59DE5E155\" sourceRef=\"node2\" targetRef=\"sid-BB9B61B2-9834-4216-A6D1-21AA568255B6\"></sequenceFlow>\n" +
            "    <userTask id=\"node3\" name=\"节点3\" flowable:candidateGroups=\"${node3}\" flowable:formFieldValidation=\"true\"></userTask>\n" +
            "    <exclusiveGateway id=\"sid-A014CA0D-F16F-43B6-B9F1-EB22ADD27698\"></exclusiveGateway>\n" +
            "    <sequenceFlow id=\"sid-47B481AF-776D-4F26-86AE-3E99B45436EC\" sourceRef=\"node3\" targetRef=\"sid-A014CA0D-F16F-43B6-B9F1-EB22ADD27698\"></sequenceFlow>\n" +
            "    <userTask id=\"node4\" name=\"节点4\" flowable:candidateGroups=\"${node4}\" flowable:formFieldValidation=\"true\"></userTask>\n" +
            "    <exclusiveGateway id=\"sid-EBB10B77-DDAE-4B30-B0D0-BFF71482DF0A\"></exclusiveGateway>\n" +
            "    <sequenceFlow id=\"sid-87EF92FF-030C-4A47-88BD-2B07F86522BD\" sourceRef=\"node4\" targetRef=\"sid-EBB10B77-DDAE-4B30-B0D0-BFF71482DF0A\"></sequenceFlow>\n" +
            "    <userTask id=\"node5\" name=\"节点5\" flowable:candidateGroups=\"${node5}\" flowable:formFieldValidation=\"true\"></userTask>\n" +
            "    <exclusiveGateway id=\"sid-B22FD888-9809-44B9-B37D-04D5EDE2A455\"></exclusiveGateway>\n" +
            "    <sequenceFlow id=\"sid-4111C06F-7EE4-4560-A8D2-858BB9FC8807\" sourceRef=\"node5\" targetRef=\"sid-B22FD888-9809-44B9-B37D-04D5EDE2A455\"></sequenceFlow>\n" +
            "    <userTask id=\"node6\" name=\"节点6\" flowable:candidateGroups=\"${node6}\" flowable:formFieldValidation=\"true\"></userTask>\n" +
            "    <exclusiveGateway id=\"sid-294B0BD1-15EB-43E2-B0CD-B78415741284\"></exclusiveGateway>\n" +
            "    <sequenceFlow id=\"sid-0C15AFD0-D846-428D-8DE8-6BC671C8187C\" sourceRef=\"node6\" targetRef=\"sid-294B0BD1-15EB-43E2-B0CD-B78415741284\"></sequenceFlow>\n" +
            "    <endEvent id=\"sid-75802766-F426-4CFC-86FF-D8D2FE734844\"></endEvent>\n" +
            "    <sequenceFlow id=\"sid-47AC73EB-5595-47D7-B5AC-368B2778AB45\" sourceRef=\"sid-243CC0FB-8000-4AF8-93DD-5976B97F04CE\" targetRef=\"sid-75802766-F426-4CFC-86FF-D8D2FE734844\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==-1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-9F7EF640-E627-4E9C-B8FA-10EC2D53DF68\" sourceRef=\"sid-BB9B61B2-9834-4216-A6D1-21AA568255B6\" targetRef=\"sid-75802766-F426-4CFC-86FF-D8D2FE734844\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==-1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-7267C218-B773-4A74-A9C8-B901B211D00C\" sourceRef=\"sid-A014CA0D-F16F-43B6-B9F1-EB22ADD27698\" targetRef=\"sid-75802766-F426-4CFC-86FF-D8D2FE734844\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==-1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-43E10F68-EB93-4D9C-9BF8-676DD06BE2F1\" sourceRef=\"sid-EBB10B77-DDAE-4B30-B0D0-BFF71482DF0A\" targetRef=\"sid-75802766-F426-4CFC-86FF-D8D2FE734844\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==-1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-02694610-1419-46E6-B807-9E5E1EEA7260\" sourceRef=\"sid-B22FD888-9809-44B9-B37D-04D5EDE2A455\" targetRef=\"sid-75802766-F426-4CFC-86FF-D8D2FE734844\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==-1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-14B4C4CA-0C9C-4679-A138-622F41430EA5\" sourceRef=\"sid-243CC0FB-8000-4AF8-93DD-5976B97F04CE\" targetRef=\"node2\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==0}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-1F153953-66C8-423A-B4DB-5DD67C62A966\" sourceRef=\"sid-BB9B61B2-9834-4216-A6D1-21AA568255B6\" targetRef=\"node3\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==0}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-5F71DC4C-2EC8-4DD0-B082-4C96A2FD9E3B\" sourceRef=\"sid-EBB10B77-DDAE-4B30-B0D0-BFF71482DF0A\" targetRef=\"node5\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==0}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-095ECEF1-7996-473D-914E-FB72ACF82C37\" sourceRef=\"sid-B22FD888-9809-44B9-B37D-04D5EDE2A455\" targetRef=\"node6\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==0}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-A0B69DA2-50C9-418C-ADB0-9862943887E5\" sourceRef=\"sid-294B0BD1-15EB-43E2-B0CD-B78415741284\" targetRef=\"sid-75802766-F426-4CFC-86FF-D8D2FE734844\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==0}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-3719B619-117C-4C76-B0DB-395EB980F79A\" sourceRef=\"sid-A014CA0D-F16F-43B6-B9F1-EB22ADD27698\" targetRef=\"node4\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==0}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-7CB44AFD-060A-46A4-B5CD-8F3E7E437070\" sourceRef=\"sid-294B0BD1-15EB-43E2-B0CD-B78415741284\" targetRef=\"node1\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-6427755D-58BB-422B-9AA9-FC92BFFA6FB8\" sourceRef=\"sid-A014CA0D-F16F-43B6-B9F1-EB22ADD27698\" targetRef=\"node1\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-BCDD592F-570C-45DC-A48A-45659285BF1C\" sourceRef=\"sid-BB9B61B2-9834-4216-A6D1-21AA568255B6\" targetRef=\"node1\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-0A466426-A054-449C-8274-DC3D2DD8471D\" sourceRef=\"sid-EBB10B77-DDAE-4B30-B0D0-BFF71482DF0A\" targetRef=\"node1\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-F9E9C51C-0880-4C64-BE59-364860A175F5\" sourceRef=\"sid-B22FD888-9809-44B9-B37D-04D5EDE2A455\" targetRef=\"node1\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-4A6DE92B-27AB-4D03-8BE9-630785186116\" sourceRef=\"sid-A014CA0D-F16F-43B6-B9F1-EB22ADD27698\" targetRef=\"node2\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==2}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-AB463EDF-9298-4406-9544-44E800A8F331\" sourceRef=\"sid-294B0BD1-15EB-43E2-B0CD-B78415741284\" targetRef=\"node2\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==2}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-7CEFF2C2-79BD-4CC7-80BC-468408032F55\" sourceRef=\"sid-EBB10B77-DDAE-4B30-B0D0-BFF71482DF0A\" targetRef=\"node2\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==2}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-0D05961D-2381-4ACC-BB14-01A45B4924CF\" sourceRef=\"sid-B22FD888-9809-44B9-B37D-04D5EDE2A455\" targetRef=\"node2\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==2}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-51E74DD7-E670-40DC-A05B-693F52E8AE2D\" sourceRef=\"sid-EBB10B77-DDAE-4B30-B0D0-BFF71482DF0A\" targetRef=\"node3\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==3}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-B9D70D01-A061-4723-9DE2-7622A8CD6076\" sourceRef=\"sid-B22FD888-9809-44B9-B37D-04D5EDE2A455\" targetRef=\"node3\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==3}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-D6193C5C-07A7-4BF8-9F32-D1793861983A\" sourceRef=\"sid-294B0BD1-15EB-43E2-B0CD-B78415741284\" targetRef=\"node3\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==3}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-25AFBBDE-D246-4D9C-9CF9-743464BA0386\" sourceRef=\"sid-B22FD888-9809-44B9-B37D-04D5EDE2A455\" targetRef=\"node4\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==4}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-FCD63A67-597F-480D-A58C-6842EDF34963\" sourceRef=\"sid-294B0BD1-15EB-43E2-B0CD-B78415741284\" targetRef=\"node4\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==4}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-99D4217F-6784-4C2A-BF0D-0CA71BDD1559\" sourceRef=\"sid-294B0BD1-15EB-43E2-B0CD-B78415741284\" targetRef=\"node5\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==5}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "  </process>\n" +
            "  <bpmndi:BPMNDiagram id=\"BPMNDiagram_step-6\">\n" +
            "    <bpmndi:BPMNPlane bpmnElement=\"step-6\" id=\"BPMNPlane_step-6\">\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"startEvent1\" id=\"BPMNShape_startEvent1\">\n" +
            "        <omgdc:Bounds height=\"30.0\" width=\"29.999999999999993\" x=\"41.81503025404894\" y=\"150.44509076214683\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"node1\" id=\"BPMNShape_node1\">\n" +
            "        <omgdc:Bounds height=\"80.0\" width=\"100.0\" x=\"116.81503025404893\" y=\"125.44509076214683\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"sid-243CC0FB-8000-4AF8-93DD-5976B97F04CE\" id=\"BPMNShape_sid-243CC0FB-8000-4AF8-93DD-5976B97F04CE\">\n" +
            "        <omgdc:Bounds height=\"40.0\" width=\"40.0\" x=\"261.81503025404896\" y=\"145.44509076214686\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"node2\" id=\"BPMNShape_node2\">\n" +
            "        <omgdc:Bounds height=\"80.00000000000003\" width=\"100.0\" x=\"271.7976966513181\" y=\"250.89018152429364\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"sid-BB9B61B2-9834-4216-A6D1-21AA568255B6\" id=\"BPMNShape_sid-BB9B61B2-9834-4216-A6D1-21AA568255B6\">\n" +
            "        <omgdc:Bounds height=\"40.0\" width=\"40.0\" x=\"416.7976966513181\" y=\"270.89018152429367\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"node3\" id=\"BPMNShape_node3\">\n" +
            "        <omgdc:Bounds height=\"80.0\" width=\"100.0\" x=\"439.05781766751386\" y=\"376.33527228644044\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"sid-A014CA0D-F16F-43B6-B9F1-EB22ADD27698\" id=\"BPMNShape_sid-A014CA0D-F16F-43B6-B9F1-EB22ADD27698\">\n" +
            "        <omgdc:Bounds height=\"40.0\" width=\"40.0\" x=\"584.0578176675139\" y=\"396.33527228644044\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"node4\" id=\"BPMNShape_node4\">\n" +
            "        <omgdc:Bounds height=\"80.00000000000006\" width=\"100.0\" x=\"606.3179386837096\" y=\"501.7803630485873\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"sid-EBB10B77-DDAE-4B30-B0D0-BFF71482DF0A\" id=\"BPMNShape_sid-EBB10B77-DDAE-4B30-B0D0-BFF71482DF0A\">\n" +
            "        <omgdc:Bounds height=\"40.0\" width=\"40.0\" x=\"751.3179386837096\" y=\"521.7803630485873\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"node5\" id=\"BPMNShape_node5\">\n" +
            "        <omgdc:Bounds height=\"80.0\" width=\"100.0\" x=\"773.5780596999053\" y=\"648.1329689377585\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"sid-B22FD888-9809-44B9-B37D-04D5EDE2A455\" id=\"BPMNShape_sid-B22FD888-9809-44B9-B37D-04D5EDE2A455\">\n" +
            "        <omgdc:Bounds height=\"40.0\" width=\"40.0\" x=\"918.5780596999053\" y=\"668.1329689377585\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"node6\" id=\"BPMNShape_node6\">\n" +
            "        <omgdc:Bounds height=\"80.0\" width=\"100.0\" x=\"940.8381807161011\" y=\"773.5780596999053\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"sid-294B0BD1-15EB-43E2-B0CD-B78415741284\" id=\"BPMNShape_sid-294B0BD1-15EB-43E2-B0CD-B78415741284\">\n" +
            "        <omgdc:Bounds height=\"40.0\" width=\"40.0\" x=\"1085.838180716101\" y=\"793.5780596999053\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"sid-75802766-F426-4CFC-86FF-D8D2FE734844\" id=\"BPMNShape_sid-75802766-F426-4CFC-86FF-D8D2FE734844\">\n" +
            "        <omgdc:Bounds height=\"28.0\" width=\"28.0\" x=\"1149.9133319863458\" y=\"799.5780596999053\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-73103441-014E-461D-8318-4C74418F380C\" id=\"BPMNEdge_sid-73103441-014E-461D-8318-4C74418F380C\" flowable:sourceDockerX=\"15.0\" flowable:sourceDockerY=\"15.0\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"71.76502874400653\" y=\"165.44509076214683\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"116.81503025404065\" y=\"165.44509076214683\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-0D05961D-2381-4ACC-BB14-01A45B4924CF\" id=\"BPMNEdge_sid-0D05961D-2381-4ACC-BB14-01A45B4924CF\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.00000000000003\">\n" +
            "        <omgdi:waypoint x=\"939.0780596999053\" y=\"707.5741203275645\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"939.0780596999053\" y=\"795.6119315354632\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"321.7976966513181\" y=\"795.6119315354631\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"321.7976966513181\" y=\"330.8401815242937\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-0F60858E-0C58-43B0-9A91-C8F59DE5E155\" id=\"BPMNEdge_sid-0F60858E-0C58-43B0-9A91-C8F59DE5E155\" flowable:sourceDockerX=\"50.0\" flowable:sourceDockerY=\"40.0\" flowable:targetDockerX=\"20.5\" flowable:targetDockerY=\"20.5\">\n" +
            "        <omgdi:waypoint x=\"371.7476966513027\" y=\"291.10641529052737\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"417.210740129567\" y=\"291.3032250025545\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-0A466426-A054-449C-8274-DC3D2DD8471D\" id=\"BPMNEdge_sid-0A466426-A054-449C-8274-DC3D2DD8471D\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"771.8179386837096\" y=\"561.2239661925959\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"771.8179386837096\" y=\"690.3000020201805\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"166.81503025404893\" y=\"690.3000020201805\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"166.81503025404893\" y=\"205.39509076214682\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-0C15AFD0-D846-428D-8DE8-6BC671C8187C\" id=\"BPMNEdge_sid-0C15AFD0-D846-428D-8DE8-6BC671C8187C\" flowable:sourceDockerX=\"50.0\" flowable:sourceDockerY=\"40.0\" flowable:targetDockerX=\"20.5\" flowable:targetDockerY=\"20.5\">\n" +
            "        <omgdi:waypoint x=\"1040.7881807160923\" y=\"813.7942934661392\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1086.2512241943618\" y=\"813.9911031781662\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-5F71DC4C-2EC8-4DD0-B082-4C96A2FD9E3B\" id=\"BPMNEdge_sid-5F71DC4C-2EC8-4DD0-B082-4C96A2FD9E3B\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"790.7496683831117\" y=\"542.2803630485873\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"823.5780596999053\" y=\"542.2803630485873\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"823.5780596999053\" y=\"648.1329689377585\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-51E74DD7-E670-40DC-A05B-693F52E8AE2D\" id=\"BPMNEdge_sid-51E74DD7-E670-40DC-A05B-693F52E8AE2D\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"57.5964638161912\">\n" +
            "        <omgdi:waypoint x=\"771.8179386837096\" y=\"561.2239661922887\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"771.8179386837096\" y=\"690.2999949065745\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"489.05781766751386\" y=\"690.2999949065745\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"489.05781766751386\" y=\"456.28527228644043\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-4111C06F-7EE4-4560-A8D2-858BB9FC8807\" id=\"BPMNEdge_sid-4111C06F-7EE4-4560-A8D2-858BB9FC8807\" flowable:sourceDockerX=\"50.0\" flowable:sourceDockerY=\"40.0\" flowable:targetDockerX=\"20.5\" flowable:targetDockerY=\"20.5\">\n" +
            "        <omgdi:waypoint x=\"873.5280596998899\" y=\"688.3492027039922\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"918.9911031781663\" y=\"688.5460124160195\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-25AFBBDE-D246-4D9C-9CF9-743464BA0386\" id=\"BPMNEdge_sid-25AFBBDE-D246-4D9C-9CF9-743464BA0386\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.00000000000003\">\n" +
            "        <omgdi:waypoint x=\"939.0780596999052\" y=\"707.5742464802361\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"939.0780596999053\" y=\"797.1606117287232\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"656.3179386837096\" y=\"797.1606117287232\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"656.3179386837096\" y=\"581.7303630485874\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-BCDD592F-570C-45DC-A48A-45659285BF1C\" id=\"BPMNEdge_sid-BCDD592F-570C-45DC-A48A-45659285BF1C\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"437.2976966513181\" y=\"310.33140789639526\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"437.2976966513181\" y=\"399.2842759826383\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"166.81503025404893\" y=\"399.2842759826383\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"166.81503025404893\" y=\"205.39509076214682\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-02694610-1419-46E6-B807-9E5E1EEA7260\" id=\"BPMNEdge_sid-02694610-1419-46E6-B807-9E5E1EEA7260\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"14.0\" flowable:targetDockerY=\"14.0\">\n" +
            "        <omgdi:waypoint x=\"958.023847376601\" y=\"688.6329689377585\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1163.9133319863458\" y=\"688.6329689377585\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1163.9133319863458\" y=\"799.5780596999053\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-1F153953-66C8-423A-B4DB-5DD67C62A966\" id=\"BPMNEdge_sid-1F153953-66C8-423A-B4DB-5DD67C62A966\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"456.22942635072036\" y=\"291.39018152429367\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"489.05781766751386\" y=\"291.39018152429367\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"489.05781766751386\" y=\"376.33527228644044\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-47AC73EB-5595-47D7-B5AC-368B2778AB45\" id=\"BPMNEdge_sid-47AC73EB-5595-47D7-B5AC-368B2778AB45\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"14.0\" flowable:targetDockerY=\"14.0\">\n" +
            "        <omgdi:waypoint x=\"301.2639556234206\" y=\"165.94509076214686\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1163.9133319863458\" y=\"165.94509076214686\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1163.9133319863458\" y=\"799.5780596999053\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-43E10F68-EB93-4D9C-9BF8-676DD06BE2F1\" id=\"BPMNEdge_sid-43E10F68-EB93-4D9C-9BF8-676DD06BE2F1\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"14.0\" flowable:targetDockerY=\"14.0\">\n" +
            "        <omgdi:waypoint x=\"790.7655227960774\" y=\"542.2803630485873\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1163.9133319863458\" y=\"542.2803630485873\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1163.9133319863458\" y=\"799.5780596999053\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-D6193C5C-07A7-4BF8-9F32-D1793861983A\" id=\"BPMNEdge_sid-D6193C5C-07A7-4BF8-9F32-D1793861983A\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"1106.338180716101\" y=\"833.0148263719776\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1106.338180716101\" y=\"885.5775851684016\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"489.05781766751386\" y=\"885.5775851684016\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"489.05781766751386\" y=\"456.28527228644043\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-AB463EDF-9298-4406-9544-44E800A8F331\" id=\"BPMNEdge_sid-AB463EDF-9298-4406-9544-44E800A8F331\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.00000000000003\">\n" +
            "        <omgdi:waypoint x=\"1106.3381807161009\" y=\"833.0148263769742\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1106.3381807161013\" y=\"885.5776122031082\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"321.7976966513181\" y=\"885.5776122031082\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"321.7976966513181\" y=\"330.8401815242937\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-14B4C4CA-0C9C-4679-A138-622F41430EA5\" id=\"BPMNEdge_sid-14B4C4CA-0C9C-4679-A138-622F41430EA5\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.000000000000014\">\n" +
            "        <omgdi:waypoint x=\"301.24109300862716\" y=\"165.94509076214686\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"321.7976966513181\" y=\"165.94509076214686\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"321.7976966513181\" y=\"250.89018152429364\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-7CB44AFD-060A-46A4-B5CD-8F3E7E437070\" id=\"BPMNEdge_sid-7CB44AFD-060A-46A4-B5CD-8F3E7E437070\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"1106.338180716101\" y=\"833.0150815767997\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1106.3381807161013\" y=\"886.9855348404753\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"167.63990850966536\" y=\"886.9855348404753\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"166.8607018260063\" y=\"205.39509076214682\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-FCD63A67-597F-480D-A58C-6842EDF34963\" id=\"BPMNEdge_sid-FCD63A67-597F-480D-A58C-6842EDF34963\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"28.871745415697376\">\n" +
            "        <omgdi:waypoint x=\"1106.338180716101\" y=\"833.0148263754472\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1106.338180716101\" y=\"885.577603940867\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"656.3179386837096\" y=\"885.577603940867\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"656.3179386837096\" y=\"581.7303630485874\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-47B481AF-776D-4F26-86AE-3E99B45436EC\" id=\"BPMNEdge_sid-47B481AF-776D-4F26-86AE-3E99B45436EC\" flowable:sourceDockerX=\"50.0\" flowable:sourceDockerY=\"40.0\" flowable:targetDockerX=\"20.5\" flowable:targetDockerY=\"20.5\">\n" +
            "        <omgdi:waypoint x=\"539.0078176675115\" y=\"416.5515060526742\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"584.4708611457747\" y=\"416.7483157647013\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-095ECEF1-7996-473D-914E-FB72ACF82C37\" id=\"BPMNEdge_sid-095ECEF1-7996-473D-914E-FB72ACF82C37\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"958.0097893992963\" y=\"688.6329689377585\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"990.8381807161011\" y=\"688.6329689377585\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"990.8381807161011\" y=\"773.5780596999053\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-F687B9A6-7D93-41A8-8077-440251B55C49\" id=\"BPMNEdge_sid-F687B9A6-7D93-41A8-8077-440251B55C49\" flowable:sourceDockerX=\"50.0\" flowable:sourceDockerY=\"40.0\" flowable:targetDockerX=\"20.5\" flowable:targetDockerY=\"20.5\">\n" +
            "        <omgdi:waypoint x=\"216.76503025404895\" y=\"165.66132452838062\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"262.2280737323056\" y=\"165.8581342404077\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-F9E9C51C-0880-4C64-BE59-364860A175F5\" id=\"BPMNEdge_sid-F9E9C51C-0880-4C64-BE59-364860A175F5\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"939.0780596999053\" y=\"707.5741203284392\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"939.0780596999053\" y=\"795.6119421196188\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"166.81503025404893\" y=\"795.6119421196188\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"166.81503025404893\" y=\"205.39509076214682\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-4A6DE92B-27AB-4D03-8BE9-630785186116\" id=\"BPMNEdge_sid-4A6DE92B-27AB-4D03-8BE9-630785186116\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"54.126498344796374\">\n" +
            "        <omgdi:waypoint x=\"604.5578176675137\" y=\"435.7768605495404\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"604.5578176675137\" y=\"529.3755047687667\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"321.7976966513181\" y=\"529.3755047687669\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"321.7976966513181\" y=\"330.8401815242937\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-9F7EF640-E627-4E9C-B8FA-10EC2D53DF68\" id=\"BPMNEdge_sid-9F7EF640-E627-4E9C-B8FA-10EC2D53DF68\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"14.0\" flowable:targetDockerY=\"14.0\">\n" +
            "        <omgdi:waypoint x=\"456.24639284009686\" y=\"291.39018152429367\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1163.9133319863458\" y=\"291.39018152429367\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1163.9133319863458\" y=\"799.5780596999053\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-7267C218-B773-4A74-A9C8-B901B211D00C\" id=\"BPMNEdge_sid-7267C218-B773-4A74-A9C8-B901B211D00C\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"14.0\" flowable:targetDockerY=\"14.0\">\n" +
            "        <omgdi:waypoint x=\"623.5061240565371\" y=\"416.83527228644044\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1163.9133319863458\" y=\"416.83527228644044\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1163.9133319863458\" y=\"799.5780596999053\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-B9D70D01-A061-4723-9DE2-7622A8CD6076\" id=\"BPMNEdge_sid-B9D70D01-A061-4723-9DE2-7622A8CD6076\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"939.0780596999053\" y=\"707.5742464815581\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"939.0780596999053\" y=\"797.1606281915961\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"489.05781766751386\" y=\"797.1606281915961\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"489.05781766751386\" y=\"456.28527228644043\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-3719B619-117C-4C76-B0DB-395EB980F79A\" id=\"BPMNEdge_sid-3719B619-117C-4C76-B0DB-395EB980F79A\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.00000000000003\">\n" +
            "        <omgdi:waypoint x=\"623.4895473669161\" y=\"416.83527228644044\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"656.3179386837096\" y=\"416.83527228644044\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"656.3179386837096\" y=\"501.7803630485873\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-87EF92FF-030C-4A47-88BD-2B07F86522BD\" id=\"BPMNEdge_sid-87EF92FF-030C-4A47-88BD-2B07F86522BD\" flowable:sourceDockerX=\"50.0\" flowable:sourceDockerY=\"40.0\" flowable:targetDockerX=\"20.5\" flowable:targetDockerY=\"20.5\">\n" +
            "        <omgdi:waypoint x=\"706.2679386837009\" y=\"541.9965968148211\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"751.7309821619705\" y=\"542.1934065268482\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-A0B69DA2-50C9-418C-ADB0-9862943887E5\" id=\"BPMNEdge_sid-A0B69DA2-50C9-418C-ADB0-9862943887E5\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"14.0\" flowable:targetDockerY=\"14.0\">\n" +
            "        <omgdi:waypoint x=\"1125.4373276761094\" y=\"813.9116124844609\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1149.9138466736151\" y=\"813.6992012711039\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-6427755D-58BB-422B-9AA9-FC92BFFA6FB8\" id=\"BPMNEdge_sid-6427755D-58BB-422B-9AA9-FC92BFFA6FB8\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"604.5578176675139\" y=\"435.7769746338117\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"604.5578176675137\" y=\"530.9241932242678\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"166.81503025404893\" y=\"530.9241932242678\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"166.81503025404893\" y=\"205.39509076214682\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-99D4217F-6784-4C2A-BF0D-0CA71BDD1559\" id=\"BPMNEdge_sid-99D4217F-6784-4C2A-BF0D-0CA71BDD1559\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"1106.338180716101\" y=\"833.0148263732694\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1106.3381807161013\" y=\"885.5775921587885\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"823.5780596999053\" y=\"885.5775921587885\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"823.5780596999053\" y=\"728.0829689377584\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-7CEFF2C2-79BD-4CC7-80BC-468408032F55\" id=\"BPMNEdge_sid-7CEFF2C2-79BD-4CC7-80BC-468408032F55\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"48.12826342113274\">\n" +
            "        <omgdi:waypoint x=\"771.8179386837096\" y=\"561.2239661925937\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"771.8179386837096\" y=\"690.3000019708929\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"321.7976966513181\" y=\"690.3000019708929\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"321.7976966513181\" y=\"330.8401815242937\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "    </bpmndi:BPMNPlane>\n" +
            "  </bpmndi:BPMNDiagram>\n" +
            "</definitions>";

    static String step7Bpm = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<definitions xmlns=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:flowable=\"http://flowable.org/bpmn\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:omgdc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:omgdi=\"http://www.omg.org/spec/DD/20100524/DI\" typeLanguage=\"http://www.w3.org/2001/XMLSchema\" expressionLanguage=\"http://www.w3.org/1999/XPath\" targetNamespace=\"http://www.flowable.org/processdef\" exporter=\"Flowable Open Source Modeler\" exporterVersion=\"6.7.2\">\n" +
            "  <process id=\"step-7\" name=\"step-7\" isExecutable=\"true\">\n" +
            "    <startEvent id=\"startEvent1\" flowable:formFieldValidation=\"true\"></startEvent>\n" +
            "    <userTask id=\"node1\" name=\"节点1\" flowable:candidateGroups=\"${node1}\" flowable:formFieldValidation=\"true\"></userTask>\n" +
            "    <sequenceFlow id=\"sid-81963434-DF37-495F-B057-A8B97C6D6276\" sourceRef=\"startEvent1\" targetRef=\"node1\"></sequenceFlow>\n" +
            "    <exclusiveGateway id=\"sid-698D2647-5961-44BF-9FC8-258DE0D88A00\"></exclusiveGateway>\n" +
            "    <sequenceFlow id=\"sid-044592F1-7A16-4DBC-B812-B7A50AC73871\" sourceRef=\"node1\" targetRef=\"sid-698D2647-5961-44BF-9FC8-258DE0D88A00\"></sequenceFlow>\n" +
            "    <userTask id=\"node2\" name=\"节点2\" flowable:candidateGroups=\"${node2}\" flowable:formFieldValidation=\"true\"></userTask>\n" +
            "    <exclusiveGateway id=\"sid-7012D5D2-DCE4-4C3C-BE59-D2F6D9982FDC\"></exclusiveGateway>\n" +
            "    <sequenceFlow id=\"sid-0698382B-C869-407E-B2FC-E4F4449CBBB5\" sourceRef=\"node2\" targetRef=\"sid-7012D5D2-DCE4-4C3C-BE59-D2F6D9982FDC\"></sequenceFlow>\n" +
            "    <userTask id=\"node3\" name=\"节点3\" flowable:candidateGroups=\"${node3}\" flowable:formFieldValidation=\"true\"></userTask>\n" +
            "    <exclusiveGateway id=\"sid-F30BDA23-CD0E-4007-A5E8-E35899EFB61B\"></exclusiveGateway>\n" +
            "    <sequenceFlow id=\"sid-BC3C2F6E-A2B5-42BB-9305-75EE0C962C00\" sourceRef=\"node3\" targetRef=\"sid-F30BDA23-CD0E-4007-A5E8-E35899EFB61B\"></sequenceFlow>\n" +
            "    <userTask id=\"node4\" name=\"节点4\" flowable:candidateGroups=\"${node4}\" flowable:formFieldValidation=\"true\"></userTask>\n" +
            "    <exclusiveGateway id=\"sid-2A6D4FC0-84A4-4BE9-B2F4-96CB052F51B5\"></exclusiveGateway>\n" +
            "    <sequenceFlow id=\"sid-BF022CE5-2929-4CBB-93B1-08E9917AD874\" sourceRef=\"node4\" targetRef=\"sid-2A6D4FC0-84A4-4BE9-B2F4-96CB052F51B5\"></sequenceFlow>\n" +
            "    <userTask id=\"node5\" name=\"节点5\" flowable:candidateGroups=\"${node5}\" flowable:formFieldValidation=\"true\"></userTask>\n" +
            "    <exclusiveGateway id=\"sid-E1FAC8E4-4D9E-49DA-BF15-564D8AB8767F\"></exclusiveGateway>\n" +
            "    <sequenceFlow id=\"sid-694D8149-3C86-4B19-A0E8-11EEC17FA909\" sourceRef=\"node5\" targetRef=\"sid-E1FAC8E4-4D9E-49DA-BF15-564D8AB8767F\"></sequenceFlow>\n" +
            "    <userTask id=\"node6\" name=\"节点6\" flowable:candidateGroups=\"${node6}\" flowable:formFieldValidation=\"true\"></userTask>\n" +
            "    <exclusiveGateway id=\"sid-FA093001-6F81-48E5-8ABA-A75D0F02C0EA\"></exclusiveGateway>\n" +
            "    <sequenceFlow id=\"sid-35B6FAF7-74FA-4CD0-8D56-7EBDDA13947A\" sourceRef=\"node6\" targetRef=\"sid-FA093001-6F81-48E5-8ABA-A75D0F02C0EA\"></sequenceFlow>\n" +
            "    <userTask id=\"node7\" name=\"节点7\" flowable:candidateGroups=\"${node7}\" flowable:formFieldValidation=\"true\"></userTask>\n" +
            "    <exclusiveGateway id=\"sid-492C4AD9-A002-46B1-9B05-1C31E48564A1\"></exclusiveGateway>\n" +
            "    <sequenceFlow id=\"sid-C639FDA2-D349-45A1-AF51-8677D1BBBD3B\" sourceRef=\"node7\" targetRef=\"sid-492C4AD9-A002-46B1-9B05-1C31E48564A1\"></sequenceFlow>\n" +
            "    <endEvent id=\"sid-F7BE6C10-CD26-4D89-B621-3859AE7D9CBF\"></endEvent>\n" +
            "    <sequenceFlow id=\"sid-C5308894-729D-4087-AE23-AD116825F51C\" sourceRef=\"sid-E1FAC8E4-4D9E-49DA-BF15-564D8AB8767F\" targetRef=\"sid-F7BE6C10-CD26-4D89-B621-3859AE7D9CBF\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==-1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-E7625F82-02A3-4352-99C5-6C2FDA297B77\" sourceRef=\"sid-FA093001-6F81-48E5-8ABA-A75D0F02C0EA\" targetRef=\"sid-F7BE6C10-CD26-4D89-B621-3859AE7D9CBF\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==-1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-26A536F7-158C-45EB-83C5-796DDDD86542\" sourceRef=\"sid-2A6D4FC0-84A4-4BE9-B2F4-96CB052F51B5\" targetRef=\"sid-F7BE6C10-CD26-4D89-B621-3859AE7D9CBF\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==-1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-21F5A030-3776-4A74-B9F5-572383884031\" sourceRef=\"sid-F30BDA23-CD0E-4007-A5E8-E35899EFB61B\" targetRef=\"sid-F7BE6C10-CD26-4D89-B621-3859AE7D9CBF\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==-1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-C5348F8C-2CC1-40C6-9CB6-E79F189D825E\" sourceRef=\"sid-7012D5D2-DCE4-4C3C-BE59-D2F6D9982FDC\" targetRef=\"sid-F7BE6C10-CD26-4D89-B621-3859AE7D9CBF\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==-1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-D5369782-1742-45D1-91AB-39F7731376D8\" sourceRef=\"sid-698D2647-5961-44BF-9FC8-258DE0D88A00\" targetRef=\"sid-F7BE6C10-CD26-4D89-B621-3859AE7D9CBF\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==-1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-B488D710-1B4D-4FEA-92F2-466087A516F6\" sourceRef=\"sid-7012D5D2-DCE4-4C3C-BE59-D2F6D9982FDC\" targetRef=\"node1\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-5B8AAE44-7FF0-4E6D-A168-3F4E23A539C3\" sourceRef=\"sid-698D2647-5961-44BF-9FC8-258DE0D88A00\" targetRef=\"node2\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==0}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-CED52025-98D8-4192-8A0C-62650C899588\" sourceRef=\"sid-7012D5D2-DCE4-4C3C-BE59-D2F6D9982FDC\" targetRef=\"node3\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==0}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-D3D24CF3-044D-4C9F-A201-3C0318EBF99F\" sourceRef=\"sid-F30BDA23-CD0E-4007-A5E8-E35899EFB61B\" targetRef=\"node4\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==0}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-7BF04BFB-6627-4C4C-B97D-CE43ECD89784\" sourceRef=\"sid-2A6D4FC0-84A4-4BE9-B2F4-96CB052F51B5\" targetRef=\"node5\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==0}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-C053B843-0C5F-484A-8425-8624342283E4\" sourceRef=\"sid-E1FAC8E4-4D9E-49DA-BF15-564D8AB8767F\" targetRef=\"node6\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==0}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-DBC3E128-4688-4586-B456-D0CB94E16E76\" sourceRef=\"sid-FA093001-6F81-48E5-8ABA-A75D0F02C0EA\" targetRef=\"node7\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==0}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-9D6AC56C-7917-4423-A86C-B3E652EA05C6\" sourceRef=\"sid-492C4AD9-A002-46B1-9B05-1C31E48564A1\" targetRef=\"sid-F7BE6C10-CD26-4D89-B621-3859AE7D9CBF\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==0}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-C7F8D0F6-A740-4E2E-AE25-DC8ADD48AAF2\" sourceRef=\"sid-F30BDA23-CD0E-4007-A5E8-E35899EFB61B\" targetRef=\"node1\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-189C59D7-C09D-4D24-8C6A-9A1C806CAB4D\" sourceRef=\"sid-F30BDA23-CD0E-4007-A5E8-E35899EFB61B\" targetRef=\"node2\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==2}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-C13DFACA-00CA-4B39-ABDF-3DFFA91016D5\" sourceRef=\"sid-2A6D4FC0-84A4-4BE9-B2F4-96CB052F51B5\" targetRef=\"node1\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-4B598D34-3AEB-4A2B-ABE7-351D248C05B9\" sourceRef=\"sid-2A6D4FC0-84A4-4BE9-B2F4-96CB052F51B5\" targetRef=\"node2\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==2}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-5C7341C8-61EE-4749-92C9-6378410FCB40\" sourceRef=\"sid-2A6D4FC0-84A4-4BE9-B2F4-96CB052F51B5\" targetRef=\"node3\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==3}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-F4269DE1-2A2F-42FE-A0F9-4DA0AD71FA95\" sourceRef=\"sid-E1FAC8E4-4D9E-49DA-BF15-564D8AB8767F\" targetRef=\"node1\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-7E5B8C80-E0E7-4AEE-AEEF-C24CD242D001\" sourceRef=\"sid-E1FAC8E4-4D9E-49DA-BF15-564D8AB8767F\" targetRef=\"node2\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==2}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-674C448E-8E02-4780-94FB-C0F8BDD9C404\" sourceRef=\"sid-E1FAC8E4-4D9E-49DA-BF15-564D8AB8767F\" targetRef=\"node3\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==3}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-C7B3929F-C487-4B8F-9473-D91BBA3A4F2E\" sourceRef=\"sid-E1FAC8E4-4D9E-49DA-BF15-564D8AB8767F\" targetRef=\"node4\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==4}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-14FC53F3-D8F5-4B06-BEC9-402C392F7408\" sourceRef=\"sid-FA093001-6F81-48E5-8ABA-A75D0F02C0EA\" targetRef=\"node1\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-04D9E975-D000-4F81-9603-41AB26DB55D0\" sourceRef=\"sid-FA093001-6F81-48E5-8ABA-A75D0F02C0EA\" targetRef=\"node2\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==2}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-4885CA8E-C0C3-4F9B-890C-ED258E944A7E\" sourceRef=\"sid-FA093001-6F81-48E5-8ABA-A75D0F02C0EA\" targetRef=\"node3\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==3}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-4E0AAB46-7C7B-4FF2-BE7A-52D3DF8FCA91\" sourceRef=\"sid-FA093001-6F81-48E5-8ABA-A75D0F02C0EA\" targetRef=\"node4\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==4}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-0CE64E43-FED6-4BFB-B992-FAD4B08A7553\" sourceRef=\"sid-FA093001-6F81-48E5-8ABA-A75D0F02C0EA\" targetRef=\"node5\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==5}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-C19C1DA8-B568-4C01-8919-3AA93D6A0480\" sourceRef=\"sid-492C4AD9-A002-46B1-9B05-1C31E48564A1\" targetRef=\"node6\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==6}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-BFAFD8B7-3991-4629-815D-82433142281C\" sourceRef=\"sid-492C4AD9-A002-46B1-9B05-1C31E48564A1\" targetRef=\"node5\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==5}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-82E69726-FECB-4154-8D3D-3DE013DD78C7\" sourceRef=\"sid-492C4AD9-A002-46B1-9B05-1C31E48564A1\" targetRef=\"node4\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==4}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-8994C380-9FD7-45FD-9529-7CCED63F2E29\" sourceRef=\"sid-492C4AD9-A002-46B1-9B05-1C31E48564A1\" targetRef=\"node3\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==3}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-B987CB7B-BDE2-42C9-BFF8-F255AA0374C7\" sourceRef=\"sid-492C4AD9-A002-46B1-9B05-1C31E48564A1\" targetRef=\"node2\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==2}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-22B85C5A-57D2-4AE2-AAE7-28A2DE7BD855\" sourceRef=\"sid-492C4AD9-A002-46B1-9B05-1C31E48564A1\" targetRef=\"node1\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "  </process>\n" +
            "  <bpmndi:BPMNDiagram id=\"BPMNDiagram_step-7\">\n" +
            "    <bpmndi:BPMNPlane bpmnElement=\"step-7\" id=\"BPMNPlane_step-7\">\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"startEvent1\" id=\"BPMNShape_startEvent1\">\n" +
            "        <omgdc:Bounds height=\"30.0\" width=\"30.0\" x=\"30.0\" y=\"55.0\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"node1\" id=\"BPMNShape_node1\">\n" +
            "        <omgdc:Bounds height=\"79.99999999999999\" width=\"100.00000000000001\" x=\"104.99999999999999\" y=\"30.000000000000004\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"sid-698D2647-5961-44BF-9FC8-258DE0D88A00\" id=\"BPMNShape_sid-698D2647-5961-44BF-9FC8-258DE0D88A00\">\n" +
            "        <omgdc:Bounds height=\"40.0\" width=\"40.0\" x=\"250.0\" y=\"49.999999999999986\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"node2\" id=\"BPMNShape_node2\">\n" +
            "        <omgdc:Bounds height=\"80.0\" width=\"100.0\" x=\"285.00000000000006\" y=\"130.00000000000006\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"sid-7012D5D2-DCE4-4C3C-BE59-D2F6D9982FDC\" id=\"BPMNShape_sid-7012D5D2-DCE4-4C3C-BE59-D2F6D9982FDC\">\n" +
            "        <omgdc:Bounds height=\"40.0\" width=\"40.0\" x=\"430.00000000000006\" y=\"150.00000000000006\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"node3\" id=\"BPMNShape_node3\">\n" +
            "        <omgdc:Bounds height=\"79.99999999999997\" width=\"99.99999999999994\" x=\"465.00000000000006\" y=\"240.00000000000003\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"sid-F30BDA23-CD0E-4007-A5E8-E35899EFB61B\" id=\"BPMNShape_sid-F30BDA23-CD0E-4007-A5E8-E35899EFB61B\">\n" +
            "        <omgdc:Bounds height=\"40.0\" width=\"40.0\" x=\"610.0\" y=\"260.0\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"node4\" id=\"BPMNShape_node4\">\n" +
            "        <omgdc:Bounds height=\"80.0\" width=\"100.0\" x=\"645.0000000000001\" y=\"345.00000000000006\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"sid-2A6D4FC0-84A4-4BE9-B2F4-96CB052F51B5\" id=\"BPMNShape_sid-2A6D4FC0-84A4-4BE9-B2F4-96CB052F51B5\">\n" +
            "        <omgdc:Bounds height=\"40.0\" width=\"40.0\" x=\"790.0000000000001\" y=\"365.00000000000006\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"node5\" id=\"BPMNShape_node5\">\n" +
            "        <omgdc:Bounds height=\"79.99999999999994\" width=\"100.0\" x=\"825.0000000000001\" y=\"450.00000000000006\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"sid-E1FAC8E4-4D9E-49DA-BF15-564D8AB8767F\" id=\"BPMNShape_sid-E1FAC8E4-4D9E-49DA-BF15-564D8AB8767F\">\n" +
            "        <omgdc:Bounds height=\"40.0\" width=\"40.0\" x=\"970.0000000000001\" y=\"470.0\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"node6\" id=\"BPMNShape_node6\">\n" +
            "        <omgdc:Bounds height=\"80.0\" width=\"99.99999999999989\" x=\"1005.0000000000001\" y=\"570.0000000000001\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"sid-FA093001-6F81-48E5-8ABA-A75D0F02C0EA\" id=\"BPMNShape_sid-FA093001-6F81-48E5-8ABA-A75D0F02C0EA\">\n" +
            "        <omgdc:Bounds height=\"40.0\" width=\"40.0\" x=\"1035.0000000000002\" y=\"690.0000000000001\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"node7\" id=\"BPMNShape_node7\">\n" +
            "        <omgdc:Bounds height=\"80.0\" width=\"99.99999999999989\" x=\"1005.0000000000003\" y=\"765.0000000000003\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"sid-492C4AD9-A002-46B1-9B05-1C31E48564A1\" id=\"BPMNShape_sid-492C4AD9-A002-46B1-9B05-1C31E48564A1\">\n" +
            "        <omgdc:Bounds height=\"40.0\" width=\"40.0\" x=\"1035.0000000000002\" y=\"885.0000000000001\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"sid-F7BE6C10-CD26-4D89-B621-3859AE7D9CBF\" id=\"BPMNShape_sid-F7BE6C10-CD26-4D89-B621-3859AE7D9CBF\">\n" +
            "        <omgdc:Bounds height=\"28.0\" width=\"28.0\" x=\"1155.0000000000002\" y=\"891.0000000000002\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-F4269DE1-2A2F-42FE-A0F9-4DA0AD71FA95\" id=\"BPMNEdge_sid-F4269DE1-2A2F-42FE-A0F9-4DA0AD71FA95\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.00000000000001\" flowable:targetDockerY=\"39.99999999999999\">\n" +
            "        <omgdi:waypoint x=\"990.5000000000001\" y=\"509.44311409883727\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"990.5000000000001\" y=\"628.0000000000002\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"155.0\" y=\"628.0000000000002\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"155.0\" y=\"109.94999999999999\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-21F5A030-3776-4A74-B9F5-572383884031\" id=\"BPMNEdge_sid-21F5A030-3776-4A74-B9F5-572383884031\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"14.0\" flowable:targetDockerY=\"14.0\">\n" +
            "        <omgdi:waypoint x=\"649.448240809506\" y=\"280.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1169.0000000000002\" y=\"280.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1169.0000000000002\" y=\"891.0000000000002\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-C639FDA2-D349-45A1-AF51-8677D1BBBD3B\" id=\"BPMNEdge_sid-C639FDA2-D349-45A1-AF51-8677D1BBBD3B\" flowable:sourceDockerX=\"50.0\" flowable:sourceDockerY=\"40.0\" flowable:targetDockerX=\"20.5\" flowable:targetDockerY=\"20.5\">\n" +
            "        <omgdi:waypoint x=\"1055.1987562189058\" y=\"844.9500000000003\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1055.4000000000003\" y=\"885.4000000000002\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-4B598D34-3AEB-4A2B-ABE7-351D248C05B9\" id=\"BPMNEdge_sid-4B598D34-3AEB-4A2B-ABE7-351D248C05B9\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"810.5000000000001\" y=\"404.44173211169294\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"810.5000000000001\" y=\"500.00000000000006\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"335.00000000000006\" y=\"500.00000000000006\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"335.00000000000006\" y=\"209.95000000000007\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-CED52025-98D8-4192-8A0C-62650C899588\" id=\"BPMNEdge_sid-CED52025-98D8-4192-8A0C-62650C899588\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"49.99999999999997\" flowable:targetDockerY=\"39.999999999999986\">\n" +
            "        <omgdi:waypoint x=\"469.4353328173375\" y=\"170.50000000000006\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"515.0\" y=\"170.50000000000006\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"515.0\" y=\"240.00000000000003\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-14FC53F3-D8F5-4B06-BEC9-402C392F7408\" id=\"BPMNEdge_sid-14FC53F3-D8F5-4B06-BEC9-402C392F7408\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.00000000000001\" flowable:targetDockerY=\"39.99999999999999\">\n" +
            "        <omgdi:waypoint x=\"1035.5000000000002\" y=\"710.5000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"155.0\" y=\"710.5000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"155.0\" y=\"109.94999999999999\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-D5369782-1742-45D1-91AB-39F7731376D8\" id=\"BPMNEdge_sid-D5369782-1742-45D1-91AB-39F7731376D8\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"14.0\" flowable:targetDockerY=\"14.0\">\n" +
            "        <omgdi:waypoint x=\"289.44894558201645\" y=\"70.49999999999999\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1169.0000000000002\" y=\"70.49999999999997\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1169.0000000000002\" y=\"891.0000000000002\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-C053B843-0C5F-484A-8425-8624342283E4\" id=\"BPMNEdge_sid-C053B843-0C5F-484A-8425-8624342283E4\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"49.99999999999994\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"1009.4353328173376\" y=\"490.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1055.0\" y=\"490.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1055.0\" y=\"570.0000000000001\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-0CE64E43-FED6-4BFB-B992-FAD4B08A7553\" id=\"BPMNEdge_sid-0CE64E43-FED6-4BFB-B992-FAD4B08A7553\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"39.99999999999997\">\n" +
            "        <omgdi:waypoint x=\"1035.5000000000002\" y=\"710.5000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"875.0000000000001\" y=\"710.5000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"875.0000000000001\" y=\"529.95\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-DBC3E128-4688-4586-B456-D0CB94E16E76\" id=\"BPMNEdge_sid-DBC3E128-4688-4586-B456-D0CB94E16E76\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"49.99999999999994\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"1055.398936170213\" y=\"729.5406216790649\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1055.211375661376\" y=\"765.0000000000003\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-C7F8D0F6-A740-4E2E-AE25-DC8ADD48AAF2\" id=\"BPMNEdge_sid-C7F8D0F6-A740-4E2E-AE25-DC8ADD48AAF2\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.00000000000001\" flowable:targetDockerY=\"39.99999999999999\">\n" +
            "        <omgdi:waypoint x=\"630.5\" y=\"299.44207775919733\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"630.5\" y=\"400.00000000000006\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"155.0\" y=\"400.00000000000006\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"155.0\" y=\"109.94999999999999\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-694D8149-3C86-4B19-A0E8-11EEC17FA909\" id=\"BPMNEdge_sid-694D8149-3C86-4B19-A0E8-11EEC17FA909\" flowable:sourceDockerX=\"50.0\" flowable:sourceDockerY=\"40.0\" flowable:targetDockerX=\"20.5\" flowable:targetDockerY=\"20.5\">\n" +
            "        <omgdi:waypoint x=\"924.9499999999904\" y=\"490.21623376623376\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"970.4130434782599\" y=\"490.4130434782609\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-4E0AAB46-7C7B-4FF2-BE7A-52D3DF8FCA91\" id=\"BPMNEdge_sid-4E0AAB46-7C7B-4FF2-BE7A-52D3DF8FCA91\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"1035.5000000000002\" y=\"710.5000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"695.0000000000001\" y=\"710.5000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"695.0000000000001\" y=\"424.95000000000005\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-26A536F7-158C-45EB-83C5-796DDDD86542\" id=\"BPMNEdge_sid-26A536F7-158C-45EB-83C5-796DDDD86542\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"14.0\" flowable:targetDockerY=\"14.0\">\n" +
            "        <omgdi:waypoint x=\"829.4473577798891\" y=\"385.50000000000006\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1169.0000000000002\" y=\"385.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1169.0000000000002\" y=\"891.0000000000002\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-B488D710-1B4D-4FEA-92F2-466087A516F6\" id=\"BPMNEdge_sid-B488D710-1B4D-4FEA-92F2-466087A516F6\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.00000000000001\" flowable:targetDockerY=\"39.99999999999999\">\n" +
            "        <omgdi:waypoint x=\"450.5\" y=\"189.4417321116929\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"450.50000000000006\" y=\"285.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"155.0\" y=\"285.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"155.0\" y=\"109.94999999999999\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-674C448E-8E02-4780-94FB-C0F8BDD9C404\" id=\"BPMNEdge_sid-674C448E-8E02-4780-94FB-C0F8BDD9C404\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"49.99999999999997\" flowable:targetDockerY=\"39.999999999999986\">\n" +
            "        <omgdi:waypoint x=\"990.5000000000001\" y=\"509.4429606240713\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"990.5000000000001\" y=\"625.0000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"515.0\" y=\"625.0000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"515.0\" y=\"319.95000000000005\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-82E69726-FECB-4154-8D3D-3DE013DD78C7\" id=\"BPMNEdge_sid-82E69726-FECB-4154-8D3D-3DE013DD78C7\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"1035.5000000000002\" y=\"905.5000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"695.0000000000001\" y=\"905.5000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"695.0000000000001\" y=\"424.95000000000005\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-5B8AAE44-7FF0-4E6D-A168-3F4E23A539C3\" id=\"BPMNEdge_sid-5B8AAE44-7FF0-4E6D-A168-3F4E23A539C3\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"289.4353328173339\" y=\"70.49999999999999\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"335.00000000000006\" y=\"70.49999999999999\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"335.00000000000006\" y=\"130.00000000000006\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-B987CB7B-BDE2-42C9-BFF8-F255AA0374C7\" id=\"BPMNEdge_sid-B987CB7B-BDE2-42C9-BFF8-F255AA0374C7\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"1035.5000000000002\" y=\"905.5000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"335.00000000000006\" y=\"905.5000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"335.00000000000006\" y=\"209.95000000000007\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-81963434-DF37-495F-B057-A8B97C6D6276\" id=\"BPMNEdge_sid-81963434-DF37-495F-B057-A8B97C6D6276\" flowable:sourceDockerX=\"15.0\" flowable:sourceDockerY=\"15.0\" flowable:targetDockerX=\"50.000000000000014\" flowable:targetDockerY=\"39.99999999999999\">\n" +
            "        <omgdi:waypoint x=\"59.9499984899576\" y=\"70.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"104.99999999999999\" y=\"70.0\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-0698382B-C869-407E-B2FC-E4F4449CBBB5\" id=\"BPMNEdge_sid-0698382B-C869-407E-B2FC-E4F4449CBBB5\" flowable:sourceDockerX=\"50.0\" flowable:sourceDockerY=\"40.0\" flowable:targetDockerX=\"20.5\" flowable:targetDockerY=\"20.5\">\n" +
            "        <omgdi:waypoint x=\"384.9499999999981\" y=\"170.21623376623384\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"430.41304347825553\" y=\"170.4130434782609\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-C5348F8C-2CC1-40C6-9CB6-E79F189D825E\" id=\"BPMNEdge_sid-C5348F8C-2CC1-40C6-9CB6-E79F189D825E\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"14.0\" flowable:targetDockerY=\"14.0\">\n" +
            "        <omgdi:waypoint x=\"469.44868146395777\" y=\"170.50000000000006\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1169.0000000000005\" y=\"170.50000000000006\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1169.0000000000002\" y=\"891.0000000000002\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-C13DFACA-00CA-4B39-ABDF-3DFFA91016D5\" id=\"BPMNEdge_sid-C13DFACA-00CA-4B39-ABDF-3DFFA91016D5\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.00000000000001\" flowable:targetDockerY=\"39.99999999999999\">\n" +
            "        <omgdi:waypoint x=\"810.5000000000001\" y=\"404.4418036332181\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"810.5000000000001\" y=\"501.00000000000006\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"155.0\" y=\"501.00000000000006\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"155.0\" y=\"109.94999999999999\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-04D9E975-D000-4F81-9603-41AB26DB55D0\" id=\"BPMNEdge_sid-04D9E975-D000-4F81-9603-41AB26DB55D0\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"1035.5000000000002\" y=\"710.5000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"335.00000000000006\" y=\"710.5000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"335.00000000000006\" y=\"209.95000000000007\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-044592F1-7A16-4DBC-B812-B7A50AC73871\" id=\"BPMNEdge_sid-044592F1-7A16-4DBC-B812-B7A50AC73871\" flowable:sourceDockerX=\"50.000000000000014\" flowable:sourceDockerY=\"39.99999999999999\" flowable:targetDockerX=\"20.5\" flowable:targetDockerY=\"20.5\">\n" +
            "        <omgdi:waypoint x=\"204.94999999999914\" y=\"70.21623376623376\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"250.41304347826087\" y=\"70.41304347826086\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-7BF04BFB-6627-4C4C-B97D-CE43ECD89784\" id=\"BPMNEdge_sid-7BF04BFB-6627-4C4C-B97D-CE43ECD89784\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"39.99999999999997\">\n" +
            "        <omgdi:waypoint x=\"829.4353328173376\" y=\"385.50000000000006\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"875.0000000000001\" y=\"385.50000000000006\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"875.0000000000001\" y=\"450.00000000000006\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-8994C380-9FD7-45FD-9529-7CCED63F2E29\" id=\"BPMNEdge_sid-8994C380-9FD7-45FD-9529-7CCED63F2E29\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"49.99999999999997\" flowable:targetDockerY=\"39.999999999999986\">\n" +
            "        <omgdi:waypoint x=\"1035.5000000000002\" y=\"905.5000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"515.0\" y=\"905.5000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"515.0\" y=\"319.95000000000005\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-189C59D7-C09D-4D24-8C6A-9A1C806CAB4D\" id=\"BPMNEdge_sid-189C59D7-C09D-4D24-8C6A-9A1C806CAB4D\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"630.5\" y=\"299.4421434494196\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"630.5\" y=\"401.00000000000006\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"335.00000000000006\" y=\"401.00000000000006\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"335.00000000000006\" y=\"209.95000000000007\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-C19C1DA8-B568-4C01-8919-3AA93D6A0480\" id=\"BPMNEdge_sid-C19C1DA8-B568-4C01-8919-3AA93D6A0480\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"49.99999999999994\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"1074.436436735333\" y=\"905.5000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1125.2578125\" y=\"905.5000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1125.2578125\" y=\"610.0000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1104.9499999999773\" y=\"610.0000000000001\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-E7625F82-02A3-4352-99C5-6C2FDA297B77\" id=\"BPMNEdge_sid-E7625F82-02A3-4352-99C5-6C2FDA297B77\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"14.0\" flowable:targetDockerY=\"14.0\">\n" +
            "        <omgdi:waypoint x=\"1074.441659330986\" y=\"710.5000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1169.0000000000002\" y=\"710.5000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1169.0000000000002\" y=\"891.0000000000002\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-22B85C5A-57D2-4AE2-AAE7-28A2DE7BD855\" id=\"BPMNEdge_sid-22B85C5A-57D2-4AE2-AAE7-28A2DE7BD855\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.00000000000001\" flowable:targetDockerY=\"39.99999999999999\">\n" +
            "        <omgdi:waypoint x=\"1035.5000000000002\" y=\"905.5000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"155.0\" y=\"905.5000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"155.0\" y=\"109.94999999999999\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-5C7341C8-61EE-4749-92C9-6378410FCB40\" id=\"BPMNEdge_sid-5C7341C8-61EE-4749-92C9-6378410FCB40\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"49.99999999999997\" flowable:targetDockerY=\"39.999999999999986\">\n" +
            "        <omgdi:waypoint x=\"810.5000000000001\" y=\"404.44180363321806\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"810.5000000000001\" y=\"501.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"515.0\" y=\"501.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"515.0\" y=\"319.95000000000005\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-35B6FAF7-74FA-4CD0-8D56-7EBDDA13947A\" id=\"BPMNEdge_sid-35B6FAF7-74FA-4CD0-8D56-7EBDDA13947A\" flowable:sourceDockerX=\"50.0\" flowable:sourceDockerY=\"40.0\" flowable:targetDockerX=\"20.5\" flowable:targetDockerY=\"20.5\">\n" +
            "        <omgdi:waypoint x=\"1055.1987562189056\" y=\"649.95\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1055.4\" y=\"690.4000000000001\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-9D6AC56C-7917-4423-A86C-B3E652EA05C6\" id=\"BPMNEdge_sid-9D6AC56C-7917-4423-A86C-B3E652EA05C6\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"14.0\" flowable:targetDockerY=\"14.0\">\n" +
            "        <omgdi:waypoint x=\"1074.5253978779842\" y=\"905.4159292035399\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1155.0001302857356\" y=\"905.0614532822135\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-BC3C2F6E-A2B5-42BB-9305-75EE0C962C00\" id=\"BPMNEdge_sid-BC3C2F6E-A2B5-42BB-9305-75EE0C962C00\" flowable:sourceDockerX=\"50.0\" flowable:sourceDockerY=\"40.0\" flowable:targetDockerX=\"20.5\" flowable:targetDockerY=\"20.5\">\n" +
            "        <omgdi:waypoint x=\"564.95\" y=\"280.2162337662338\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"610.4130434782609\" y=\"280.4130434782609\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-C5308894-729D-4087-AE23-AD116825F51C\" id=\"BPMNEdge_sid-C5308894-729D-4087-AE23-AD116825F51C\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"14.0\" flowable:targetDockerY=\"14.0\">\n" +
            "        <omgdi:waypoint x=\"1009.4446948488243\" y=\"490.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1169.0000000000002\" y=\"490.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1169.0000000000002\" y=\"891.0000000000002\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-7E5B8C80-E0E7-4AEE-AEEF-C24CD242D001\" id=\"BPMNEdge_sid-7E5B8C80-E0E7-4AEE-AEEF-C24CD242D001\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"990.5\" y=\"509.4430125368732\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"990.5000000000001\" y=\"626.0000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"335.0\" y=\"626.0000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"335.00000000000006\" y=\"209.95000000000007\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-C7B3929F-C487-4B8F-9473-D91BBA3A4F2E\" id=\"BPMNEdge_sid-C7B3929F-C487-4B8F-9473-D91BBA3A4F2E\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"990.5000000000001\" y=\"509.4429606240713\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"990.5000000000001\" y=\"625.0000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"695.0000000000001\" y=\"625.0000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"695.0000000000001\" y=\"424.95000000000005\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-BF022CE5-2929-4CBB-93B1-08E9917AD874\" id=\"BPMNEdge_sid-BF022CE5-2929-4CBB-93B1-08E9917AD874\" flowable:sourceDockerX=\"50.0\" flowable:sourceDockerY=\"40.0\" flowable:targetDockerX=\"20.5\" flowable:targetDockerY=\"20.5\">\n" +
            "        <omgdi:waypoint x=\"744.9499999999978\" y=\"385.2162337662338\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"790.413043478261\" y=\"385.41304347826093\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-D3D24CF3-044D-4C9F-A201-3C0318EBF99F\" id=\"BPMNEdge_sid-D3D24CF3-044D-4C9F-A201-3C0318EBF99F\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"649.4353328173374\" y=\"280.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"695.0000000000001\" y=\"280.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"695.0000000000001\" y=\"345.00000000000006\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-4885CA8E-C0C3-4F9B-890C-ED258E944A7E\" id=\"BPMNEdge_sid-4885CA8E-C0C3-4F9B-890C-ED258E944A7E\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"49.99999999999997\" flowable:targetDockerY=\"39.999999999999986\">\n" +
            "        <omgdi:waypoint x=\"1035.5000000000002\" y=\"710.5000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"515.0\" y=\"710.5000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"515.0\" y=\"319.95000000000005\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-BFAFD8B7-3991-4629-815D-82433142281C\" id=\"BPMNEdge_sid-BFAFD8B7-3991-4629-815D-82433142281C\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"39.99999999999997\">\n" +
            "        <omgdi:waypoint x=\"1035.5000000000002\" y=\"905.5000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"875.0000000000001\" y=\"905.5000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"875.0000000000001\" y=\"529.95\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "    </bpmndi:BPMNPlane>\n" +
            "  </bpmndi:BPMNDiagram>\n" +
            "</definitions>";

    static String step8Bpm = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<definitions xmlns=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:flowable=\"http://flowable.org/bpmn\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:omgdc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:omgdi=\"http://www.omg.org/spec/DD/20100524/DI\" typeLanguage=\"http://www.w3.org/2001/XMLSchema\" expressionLanguage=\"http://www.w3.org/1999/XPath\" targetNamespace=\"http://www.flowable.org/processdef\" exporter=\"Flowable Open Source Modeler\" exporterVersion=\"6.7.2\">\n" +
            "  <process id=\"step-8\" name=\"step-8\" isExecutable=\"true\">\n" +
            "    <startEvent id=\"start\" flowable:formFieldValidation=\"true\"></startEvent>\n" +
            "    <userTask id=\"node1\" name=\"节点1\" flowable:formFieldValidation=\"true\"></userTask>\n" +
            "    <sequenceFlow id=\"sid-48D8ED10-FD7E-4A91-A861-C507EEF02743\" sourceRef=\"start\" targetRef=\"node1\"></sequenceFlow>\n" +
            "    <exclusiveGateway id=\"gw1\"></exclusiveGateway>\n" +
            "    <sequenceFlow id=\"sid-E518C8FC-FE94-4517-8438-9A37DF82FF8C\" sourceRef=\"node1\" targetRef=\"gw1\"></sequenceFlow>\n" +
            "    <userTask id=\"node2\" name=\"节点2\" flowable:formFieldValidation=\"true\"></userTask>\n" +
            "    <exclusiveGateway id=\"gw2\"></exclusiveGateway>\n" +
            "    <sequenceFlow id=\"sid-980F2B68-B705-4B4E-BE1F-C67479807DF6\" sourceRef=\"node2\" targetRef=\"gw2\"></sequenceFlow>\n" +
            "    <userTask id=\"node3\" name=\"节点3\" flowable:formFieldValidation=\"true\"></userTask>\n" +
            "    <exclusiveGateway id=\"gw3\"></exclusiveGateway>\n" +
            "    <sequenceFlow id=\"sid-8099FE77-4503-402F-A230-F1043FAFAB56\" sourceRef=\"node3\" targetRef=\"gw3\"></sequenceFlow>\n" +
            "    <userTask id=\"node4\" name=\"节点4\" flowable:formFieldValidation=\"true\"></userTask>\n" +
            "    <exclusiveGateway id=\"gw4\"></exclusiveGateway>\n" +
            "    <sequenceFlow id=\"sid-96392A74-1FC2-4117-A0C0-B266351D156B\" sourceRef=\"node4\" targetRef=\"gw4\"></sequenceFlow>\n" +
            "    <userTask id=\"node5\" name=\"节点5\" flowable:formFieldValidation=\"true\"></userTask>\n" +
            "    <exclusiveGateway id=\"gw5\"></exclusiveGateway>\n" +
            "    <sequenceFlow id=\"sid-DB951FFB-4F22-4236-A8DC-E172E0BE175A\" sourceRef=\"node5\" targetRef=\"gw5\"></sequenceFlow>\n" +
            "    <userTask id=\"node6\" name=\"节点6\" flowable:formFieldValidation=\"true\"></userTask>\n" +
            "    <exclusiveGateway id=\"gw6\"></exclusiveGateway>\n" +
            "    <sequenceFlow id=\"sid-FDDA9D88-A0E6-49EA-99BD-59FEFCADE049\" sourceRef=\"node6\" targetRef=\"gw6\"></sequenceFlow>\n" +
            "    <userTask id=\"node7\" name=\"节点7\" flowable:formFieldValidation=\"true\"></userTask>\n" +
            "    <exclusiveGateway id=\"gw7\"></exclusiveGateway>\n" +
            "    <sequenceFlow id=\"sid-B419B259-0C3E-4BA5-AE95-B85C41B102D2\" sourceRef=\"node7\" targetRef=\"gw7\"></sequenceFlow>\n" +
            "    <userTask id=\"node8\" name=\"节点8\" flowable:formFieldValidation=\"true\"></userTask>\n" +
            "    <exclusiveGateway id=\"gw8\"></exclusiveGateway>\n" +
            "    <endEvent id=\"end\"></endEvent>\n" +
            "    <sequenceFlow id=\"sid-D23EAC90-FC0E-4F84-9113-6B13D4789F1C\" sourceRef=\"gw1\" targetRef=\"end\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==-1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-9A365BB7-EF7F-4D35-B53A-6CBDD10E019A\" sourceRef=\"gw2\" targetRef=\"end\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==-1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-F52D6C87-E4CA-4B53-AE6B-ECB4877A3B51\" sourceRef=\"gw4\" targetRef=\"end\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==-1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-9ED3692C-0F58-4CCE-BDBB-C1CA95D6714C\" sourceRef=\"gw5\" targetRef=\"end\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==-1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-F550D6B7-18B1-43F4-AC3C-D713810ECF30\" sourceRef=\"gw6\" targetRef=\"end\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==-1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-EBDA755A-46C5-4A63-934C-8296805829C0\" sourceRef=\"gw7\" targetRef=\"end\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==-1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-BF368CDC-F619-4E55-AB6C-6ED72A54EF91\" sourceRef=\"gw2\" targetRef=\"node1\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-A315820A-CD4B-45B4-97C1-1D32D15CEF0F\" sourceRef=\"gw3\" targetRef=\"node1\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-DC8363C5-B0C3-44A2-BCBA-24AD429B226D\" sourceRef=\"gw3\" targetRef=\"node2\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==2}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-0A23E330-B4DF-4C91-8827-D9125A560366\" sourceRef=\"gw4\" targetRef=\"node3\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==3}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-2010AF93-B8C0-4D49-869B-BB42731BACB7\" sourceRef=\"gw4\" targetRef=\"node2\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==2}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-6C44E340-FDD0-4005-BBAC-8B4CF83AECD6\" sourceRef=\"gw4\" targetRef=\"node1\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-61AF99C9-854E-4AD5-98F1-DB0B98B5E8D6\" sourceRef=\"gw5\" targetRef=\"node4\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==4}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-1CF1D67D-9B83-47F9-A8C0-C6EA4C4EB688\" sourceRef=\"gw5\" targetRef=\"node3\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==3}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-D2246E00-7A60-4FAF-B10C-6253481FA1E4\" sourceRef=\"gw5\" targetRef=\"node2\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==2}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-FBD6E547-9366-47AC-B5AF-EDAEC3494519\" sourceRef=\"gw5\" targetRef=\"node1\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-29CF074E-F1E8-4D0A-8C66-2B2040C49C43\" sourceRef=\"gw6\" targetRef=\"node5\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==5}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-30C5DD4A-A1E5-427F-84CB-B23496A210E1\" sourceRef=\"gw6\" targetRef=\"node4\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==4}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-044B91A5-E1EC-4C89-B153-EF7607AAEC57\" sourceRef=\"gw6\" targetRef=\"node3\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==3}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-76E6E361-4616-4367-BD85-AB40701429EB\" sourceRef=\"gw6\" targetRef=\"node2\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==2}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-A9F4A4AA-40B6-4562-9F58-8CD5002F26B6\" sourceRef=\"gw6\" targetRef=\"node1\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-D203BBF7-BE32-4161-90EB-AD13DA265B2B\" sourceRef=\"gw7\" targetRef=\"node2\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==2}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-1A8FC063-05B6-43DD-AE64-93DA440E06C5\" sourceRef=\"gw7\" targetRef=\"node3\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==3}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-518F9D84-9206-47E1-A981-12CF92DC33F4\" sourceRef=\"gw7\" targetRef=\"node4\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==4}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-E01D0ED7-470F-4E45-8749-2BDFDFAB50EC\" sourceRef=\"gw7\" targetRef=\"node5\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==5}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-7AE60270-AB1F-40EC-9BDC-CB18170A7A77\" sourceRef=\"gw7\" targetRef=\"node6\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==6}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-1E32327F-382C-4148-8AD7-CF0A44AD0B5B\" sourceRef=\"gw3\" targetRef=\"end\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==-1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-E37882D3-2B49-447B-A547-01FB73556305\" sourceRef=\"gw8\" targetRef=\"node6\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==6}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-79C3309A-73F1-43A7-94B6-513B5C376A18\" sourceRef=\"gw8\" targetRef=\"node5\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==5}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-2E9217D5-8519-4397-B5C0-B9AB69E83527\" sourceRef=\"gw8\" targetRef=\"node4\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==4}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-C002DCA6-47EE-41F1-A29E-20F0DCC98B55\" sourceRef=\"gw8\" targetRef=\"node3\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==3}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-3CF3FD91-75A2-48DA-AC43-3F1461A34641\" sourceRef=\"gw8\" targetRef=\"node2\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==2}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-637A126E-4EAD-45F1-A4F8-4D11C950F2D0\" sourceRef=\"gw8\" targetRef=\"node1\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-F2451BAD-2031-4536-AB9D-D5E14F148AF3\" sourceRef=\"gw7\" targetRef=\"node1\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==1}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-2FED6DA1-D358-425E-A522-645BE1E3A0C5\" sourceRef=\"node8\" targetRef=\"gw8\"></sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-13BE7562-1A25-4B04-9FC4-F61812758B04\" sourceRef=\"gw8\" targetRef=\"node7\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==7}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-F5D06ADB-2C07-4ED2-83B8-97BB5AF0C450\" sourceRef=\"gw8\" targetRef=\"end\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==0}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-2D37DD5B-9771-4499-AE69-6DFEE88DEB5A\" sourceRef=\"gw7\" targetRef=\"node8\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==0}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-95FD9D8A-BE26-4822-9466-F184DCBFD290\" sourceRef=\"gw6\" targetRef=\"node7\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==0}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-7670CE25-9926-407F-8417-A955B410186D\" sourceRef=\"gw5\" targetRef=\"node6\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==0}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-40B8C367-3D5B-463A-992C-D3DD2DF27865\" sourceRef=\"gw4\" targetRef=\"node5\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==0}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-88DE05A9-9591-43E6-BC1B-47ABDABD8497\" sourceRef=\"gw3\" targetRef=\"node4\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==0}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-A18FC31F-FDD0-4296-B039-95E1A00044A5\" sourceRef=\"gw2\" targetRef=\"node3\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==0}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "    <sequenceFlow id=\"sid-6FC2A9E3-4B31-4246-997F-E4DC2D37C594\" sourceRef=\"gw1\" targetRef=\"node2\">\n" +
            "      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${flow==0}]]></conditionExpression>\n" +
            "    </sequenceFlow>\n" +
            "  </process>\n" +
            "  <bpmndi:BPMNDiagram id=\"BPMNDiagram_step-8\">\n" +
            "    <bpmndi:BPMNPlane bpmnElement=\"step-8\" id=\"BPMNPlane_step-8\">\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"start\" id=\"BPMNShape_start\">\n" +
            "        <omgdc:Bounds height=\"30.0\" width=\"30.0\" x=\"10.0\" y=\"70.0\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"node1\" id=\"BPMNShape_node1\">\n" +
            "        <omgdc:Bounds height=\"80.0\" width=\"100.0\" x=\"55.0\" y=\"45.0\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"gw1\" id=\"BPMNShape_gw1\">\n" +
            "        <omgdc:Bounds height=\"40.0\" width=\"40.0\" x=\"175.0\" y=\"65.0\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"node2\" id=\"BPMNShape_node2\">\n" +
            "        <omgdc:Bounds height=\"80.0\" width=\"100.0\" x=\"200.0\" y=\"130.0\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"gw2\" id=\"BPMNShape_gw2\">\n" +
            "        <omgdc:Bounds height=\"40.0\" width=\"40.0\" x=\"325.0\" y=\"150.0\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"node3\" id=\"BPMNShape_node3\">\n" +
            "        <omgdc:Bounds height=\"80.0\" width=\"100.0\" x=\"355.0\" y=\"220.0\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"gw3\" id=\"BPMNShape_gw3\">\n" +
            "        <omgdc:Bounds height=\"40.0\" width=\"40.0\" x=\"475.0\" y=\"240.0\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"node4\" id=\"BPMNShape_node4\">\n" +
            "        <omgdc:Bounds height=\"80.0\" width=\"100.0\" x=\"505.0\" y=\"325.0\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"gw4\" id=\"BPMNShape_gw4\">\n" +
            "        <omgdc:Bounds height=\"40.0\" width=\"40.0\" x=\"625.0\" y=\"345.0\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"node5\" id=\"BPMNShape_node5\">\n" +
            "        <omgdc:Bounds height=\"80.0\" width=\"100.0\" x=\"655.0\" y=\"430.0\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"gw5\" id=\"BPMNShape_gw5\">\n" +
            "        <omgdc:Bounds height=\"40.0\" width=\"40.0\" x=\"775.0\" y=\"450.0\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"node6\" id=\"BPMNShape_node6\">\n" +
            "        <omgdc:Bounds height=\"80.0\" width=\"100.0\" x=\"805.0\" y=\"520.0\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"gw6\" id=\"BPMNShape_gw6\">\n" +
            "        <omgdc:Bounds height=\"40.0\" width=\"40.0\" x=\"925.0\" y=\"540.0\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"node7\" id=\"BPMNShape_node7\">\n" +
            "        <omgdc:Bounds height=\"80.0\" width=\"100.0\" x=\"955.0\" y=\"610.0\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"gw7\" id=\"BPMNShape_gw7\">\n" +
            "        <omgdc:Bounds height=\"40.0\" width=\"40.0\" x=\"985.0\" y=\"715.0\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"node8\" id=\"BPMNShape_node8\">\n" +
            "        <omgdc:Bounds height=\"80.0\" width=\"100.0\" x=\"955.0\" y=\"805.0\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"gw8\" id=\"BPMNShape_gw8\">\n" +
            "        <omgdc:Bounds height=\"40.0\" width=\"40.0\" x=\"985.0\" y=\"925.0\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape bpmnElement=\"end\" id=\"BPMNShape_end\">\n" +
            "        <omgdc:Bounds height=\"28.0\" width=\"28.0\" x=\"1095.0\" y=\"931.0\"></omgdc:Bounds>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-9A365BB7-EF7F-4D35-B53A-6CBDD10E019A\" id=\"BPMNEdge_sid-9A365BB7-EF7F-4D35-B53A-6CBDD10E019A\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"14.0\" flowable:targetDockerY=\"14.0\">\n" +
            "        <omgdi:waypoint x=\"364.4487591669962\" y=\"170.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1109.0\" y=\"170.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1109.0\" y=\"931.0\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-F2451BAD-2031-4536-AB9D-D5E14F148AF3\" id=\"BPMNEdge_sid-F2451BAD-2031-4536-AB9D-D5E14F148AF3\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"985.5\" y=\"735.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"105.0\" y=\"735.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"105.0\" y=\"124.95\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-D203BBF7-BE32-4161-90EB-AD13DA265B2B\" id=\"BPMNEdge_sid-D203BBF7-BE32-4161-90EB-AD13DA265B2B\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"985.5\" y=\"735.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"250.0\" y=\"735.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"250.0\" y=\"209.95000000000002\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-BF368CDC-F619-4E55-AB6C-6ED72A54EF91\" id=\"BPMNEdge_sid-BF368CDC-F619-4E55-AB6C-6ED72A54EF91\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"345.5\" y=\"189.43965611353715\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"345.5\" y=\"262.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"105.0\" y=\"262.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"105.0\" y=\"124.95\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-3CF3FD91-75A2-48DA-AC43-3F1461A34641\" id=\"BPMNEdge_sid-3CF3FD91-75A2-48DA-AC43-3F1461A34641\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"985.5\" y=\"945.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"250.0\" y=\"945.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"250.0\" y=\"209.95000000000002\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-6C44E340-FDD0-4005-BBAC-8B4CF83AECD6\" id=\"BPMNEdge_sid-6C44E340-FDD0-4005-BBAC-8B4CF83AECD6\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"645.5\" y=\"384.4411942379183\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"645.5\" y=\"473.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"105.0\" y=\"473.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"105.0\" y=\"124.95\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-61AF99C9-854E-4AD5-98F1-DB0B98B5E8D6\" id=\"BPMNEdge_sid-61AF99C9-854E-4AD5-98F1-DB0B98B5E8D6\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"795.5\" y=\"489.44048694779116\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"795.5\" y=\"570.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"555.0\" y=\"570.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"555.0\" y=\"404.95000000000005\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-F5D06ADB-2C07-4ED2-83B8-97BB5AF0C450\" id=\"BPMNEdge_sid-F5D06ADB-2C07-4ED2-83B8-97BB5AF0C450\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"14.0\" flowable:targetDockerY=\"14.0\">\n" +
            "        <omgdi:waypoint x=\"1024.5327109602329\" y=\"945.4077669902913\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1095.000157275593\" y=\"945.0673906757257\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-9ED3692C-0F58-4CCE-BDBB-C1CA95D6714C\" id=\"BPMNEdge_sid-9ED3692C-0F58-4CCE-BDBB-C1CA95D6714C\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"14.0\" flowable:targetDockerY=\"14.0\">\n" +
            "        <omgdi:waypoint x=\"814.446978635204\" y=\"470.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1109.0\" y=\"470.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1109.0\" y=\"931.0\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-2D37DD5B-9771-4499-AE69-6DFEE88DEB5A\" id=\"BPMNEdge_sid-2D37DD5B-9771-4499-AE69-6DFEE88DEB5A\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"1005.4128440366973\" y=\"754.5281622364802\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1005.1824200913242\" y=\"805.0\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-7AE60270-AB1F-40EC-9BDC-CB18170A7A77\" id=\"BPMNEdge_sid-7AE60270-AB1F-40EC-9BDC-CB18170A7A77\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"985.5\" y=\"735.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"855.0\" y=\"735.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"855.0\" y=\"599.9499999999999\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-F52D6C87-E4CA-4B53-AE6B-ECB4877A3B51\" id=\"BPMNEdge_sid-F52D6C87-E4CA-4B53-AE6B-ECB4877A3B51\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"14.0\" flowable:targetDockerY=\"14.0\">\n" +
            "        <omgdi:waypoint x=\"664.4479562122518\" y=\"365.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1109.0\" y=\"365.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1109.0\" y=\"931.0\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-D2246E00-7A60-4FAF-B10C-6253481FA1E4\" id=\"BPMNEdge_sid-D2246E00-7A60-4FAF-B10C-6253481FA1E4\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"795.5\" y=\"489.4403904665314\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"795.5\" y=\"569.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"250.0\" y=\"569.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"250.0\" y=\"209.95000000000002\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-E01D0ED7-470F-4E45-8749-2BDFDFAB50EC\" id=\"BPMNEdge_sid-E01D0ED7-470F-4E45-8749-2BDFDFAB50EC\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"985.5\" y=\"735.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"705.0\" y=\"735.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"705.0\" y=\"509.95000000000005\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-2FED6DA1-D358-425E-A522-645BE1E3A0C5\" id=\"BPMNEdge_sid-2FED6DA1-D358-425E-A522-645BE1E3A0C5\" flowable:sourceDockerX=\"50.0\" flowable:sourceDockerY=\"40.0\" flowable:targetDockerX=\"20.5\" flowable:targetDockerY=\"20.5\">\n" +
            "        <omgdi:waypoint x=\"1005.1987562189055\" y=\"884.9499999999999\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1005.4\" y=\"925.4\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-2010AF93-B8C0-4D49-869B-BB42731BACB7\" id=\"BPMNEdge_sid-2010AF93-B8C0-4D49-869B-BB42731BACB7\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"645.5\" y=\"384.4412753222836\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"645.5\" y=\"474.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"250.0\" y=\"474.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"250.0\" y=\"209.95000000000002\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-DB951FFB-4F22-4236-A8DC-E172E0BE175A\" id=\"BPMNEdge_sid-DB951FFB-4F22-4236-A8DC-E172E0BE175A\" flowable:sourceDockerX=\"50.0\" flowable:sourceDockerY=\"40.0\" flowable:targetDockerX=\"20.5\" flowable:targetDockerY=\"20.5\">\n" +
            "        <omgdi:waypoint x=\"754.9499999999938\" y=\"470.2759668508287\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"775.3888888888832\" y=\"470.38888888888886\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-F550D6B7-18B1-43F4-AC3C-D713810ECF30\" id=\"BPMNEdge_sid-F550D6B7-18B1-43F4-AC3C-D713810ECF30\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"14.0\" flowable:targetDockerY=\"14.0\">\n" +
            "        <omgdi:waypoint x=\"964.4442084351786\" y=\"560.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1109.0\" y=\"560.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1109.0\" y=\"931.0\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-13BE7562-1A25-4B04-9FC4-F61812758B04\" id=\"BPMNEdge_sid-13BE7562-1A25-4B04-9FC4-F61812758B04\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"78.8333740234375\" flowable:targetDockerY=\"38.66668701171875\">\n" +
            "        <omgdi:waypoint x=\"1024.436154416336\" y=\"945.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1073.8333740234375\" y=\"945.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1073.8333740234375\" y=\"648.6666870117188\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1054.95\" y=\"648.6666870117188\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-A9F4A4AA-40B6-4562-9F58-8CD5002F26B6\" id=\"BPMNEdge_sid-A9F4A4AA-40B6-4562-9F58-8CD5002F26B6\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"945.5\" y=\"579.4396561135371\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"945.5\" y=\"652.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"105.0\" y=\"652.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"105.0\" y=\"124.95\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-79C3309A-73F1-43A7-94B6-513B5C376A18\" id=\"BPMNEdge_sid-79C3309A-73F1-43A7-94B6-513B5C376A18\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"985.5\" y=\"945.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"705.0\" y=\"945.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"705.0\" y=\"509.95000000000005\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-8099FE77-4503-402F-A230-F1043FAFAB56\" id=\"BPMNEdge_sid-8099FE77-4503-402F-A230-F1043FAFAB56\" flowable:sourceDockerX=\"50.0\" flowable:sourceDockerY=\"40.0\" flowable:targetDockerX=\"20.5\" flowable:targetDockerY=\"20.5\">\n" +
            "        <omgdi:waypoint x=\"454.9499999999938\" y=\"260.2759668508287\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"475.3888888888889\" y=\"260.3888888888889\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-0A23E330-B4DF-4C91-8827-D9125A560366\" id=\"BPMNEdge_sid-0A23E330-B4DF-4C91-8827-D9125A560366\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"645.5\" y=\"384.4412753222836\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"645.5\" y=\"474.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"405.0\" y=\"474.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"405.0\" y=\"299.95000000000005\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-6FC2A9E3-4B31-4246-997F-E4DC2D37C594\" id=\"BPMNEdge_sid-6FC2A9E3-4B31-4246-997F-E4DC2D37C594\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"214.43264652013568\" y=\"85.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"250.0\" y=\"85.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"250.0\" y=\"130.0\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-D23EAC90-FC0E-4F84-9113-6B13D4789F1C\" id=\"BPMNEdge_sid-D23EAC90-FC0E-4F84-9113-6B13D4789F1C\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"14.0\" flowable:targetDockerY=\"14.0\">\n" +
            "        <omgdi:waypoint x=\"214.44896289404554\" y=\"85.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1109.0\" y=\"85.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1109.0\" y=\"931.0\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-7670CE25-9926-407F-8417-A955B410186D\" id=\"BPMNEdge_sid-7670CE25-9926-407F-8417-A955B410186D\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"814.434102348971\" y=\"470.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"855.0\" y=\"470.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"855.0\" y=\"520.0\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-E518C8FC-FE94-4517-8438-9A37DF82FF8C\" id=\"BPMNEdge_sid-E518C8FC-FE94-4517-8438-9A37DF82FF8C\" flowable:sourceDockerX=\"50.0\" flowable:sourceDockerY=\"40.0\" flowable:targetDockerX=\"20.5\" flowable:targetDockerY=\"20.5\">\n" +
            "        <omgdi:waypoint x=\"154.94999999999894\" y=\"85.27596685082872\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"175.38888888888832\" y=\"85.38888888888889\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-EBDA755A-46C5-4A63-934C-8296805829C0\" id=\"BPMNEdge_sid-EBDA755A-46C5-4A63-934C-8296805829C0\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"14.0\" flowable:targetDockerY=\"14.0\">\n" +
            "        <omgdi:waypoint x=\"1024.4408542470812\" y=\"735.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1109.0\" y=\"735.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1109.0\" y=\"931.0\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-88DE05A9-9591-43E6-BC1B-47ABDABD8497\" id=\"BPMNEdge_sid-88DE05A9-9591-43E6-BC1B-47ABDABD8497\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"514.4341023489933\" y=\"260.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"555.0\" y=\"260.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"555.0\" y=\"325.0\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-A18FC31F-FDD0-4296-B039-95E1A00044A5\" id=\"BPMNEdge_sid-A18FC31F-FDD0-4296-B039-95E1A00044A5\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"364.43410234897107\" y=\"170.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"405.0\" y=\"170.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"405.0\" y=\"220.0\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-1E32327F-382C-4148-8AD7-CF0A44AD0B5B\" id=\"BPMNEdge_sid-1E32327F-382C-4148-8AD7-CF0A44AD0B5B\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"14.0\" flowable:targetDockerY=\"14.0\">\n" +
            "        <omgdi:waypoint x=\"514.4484558344199\" y=\"260.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1109.0\" y=\"260.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1109.0\" y=\"931.0\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-40B8C367-3D5B-463A-992C-D3DD2DF27865\" id=\"BPMNEdge_sid-40B8C367-3D5B-463A-992C-D3DD2DF27865\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"664.434102348971\" y=\"365.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"705.0\" y=\"365.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"705.0\" y=\"430.0\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-96392A74-1FC2-4117-A0C0-B266351D156B\" id=\"BPMNEdge_sid-96392A74-1FC2-4117-A0C0-B266351D156B\" flowable:sourceDockerX=\"50.0\" flowable:sourceDockerY=\"40.0\" flowable:targetDockerX=\"20.5\" flowable:targetDockerY=\"20.5\">\n" +
            "        <omgdi:waypoint x=\"604.9499999999938\" y=\"365.2759668508287\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"625.3888888888889\" y=\"365.3888888888889\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-B419B259-0C3E-4BA5-AE95-B85C41B102D2\" id=\"BPMNEdge_sid-B419B259-0C3E-4BA5-AE95-B85C41B102D2\" flowable:sourceDockerX=\"50.0\" flowable:sourceDockerY=\"40.0\" flowable:targetDockerX=\"20.5\" flowable:targetDockerY=\"20.5\">\n" +
            "        <omgdi:waypoint x=\"1005.2336257309942\" y=\"689.9499999999999\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1005.3823529411765\" y=\"715.3823529411765\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-29CF074E-F1E8-4D0A-8C66-2B2040C49C43\" id=\"BPMNEdge_sid-29CF074E-F1E8-4D0A-8C66-2B2040C49C43\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"945.5\" y=\"579.4397678185745\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"945.5\" y=\"653.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"705.0\" y=\"653.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"705.0\" y=\"509.95000000000005\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-637A126E-4EAD-45F1-A4F8-4D11C950F2D0\" id=\"BPMNEdge_sid-637A126E-4EAD-45F1-A4F8-4D11C950F2D0\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"985.5\" y=\"945.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"105.0\" y=\"945.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"105.0\" y=\"124.95\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-A315820A-CD4B-45B4-97C1-1D32D15CEF0F\" id=\"BPMNEdge_sid-A315820A-CD4B-45B4-97C1-1D32D15CEF0F\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"495.5\" y=\"279.44094168260034\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"495.5\" y=\"365.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"105.0\" y=\"365.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"105.0\" y=\"124.95\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-1CF1D67D-9B83-47F9-A8C0-C6EA4C4EB688\" id=\"BPMNEdge_sid-1CF1D67D-9B83-47F9-A8C0-C6EA4C4EB688\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"795.5\" y=\"489.4403904665314\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"795.5\" y=\"569.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"405.0\" y=\"569.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"405.0\" y=\"299.95000000000005\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-FBD6E547-9366-47AC-B5AF-EDAEC3494519\" id=\"BPMNEdge_sid-FBD6E547-9366-47AC-B5AF-EDAEC3494519\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"795.5\" y=\"489.44048694779116\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"795.5\" y=\"570.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"105.0\" y=\"570.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"105.0\" y=\"124.95\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-DC8363C5-B0C3-44A2-BCBA-24AD429B226D\" id=\"BPMNEdge_sid-DC8363C5-B0C3-44A2-BCBA-24AD429B226D\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"495.5\" y=\"279.44094168260034\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"495.5\" y=\"365.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"250.0\" y=\"365.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"250.0\" y=\"209.95000000000002\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-2E9217D5-8519-4397-B5C0-B9AB69E83527\" id=\"BPMNEdge_sid-2E9217D5-8519-4397-B5C0-B9AB69E83527\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"985.5\" y=\"945.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"555.0\" y=\"945.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"555.0\" y=\"404.95000000000005\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-518F9D84-9206-47E1-A981-12CF92DC33F4\" id=\"BPMNEdge_sid-518F9D84-9206-47E1-A981-12CF92DC33F4\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"985.5\" y=\"735.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"555.0\" y=\"735.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"555.0\" y=\"404.95000000000005\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-30C5DD4A-A1E5-427F-84CB-B23496A210E1\" id=\"BPMNEdge_sid-30C5DD4A-A1E5-427F-84CB-B23496A210E1\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"945.5\" y=\"579.4396561135371\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"945.5\" y=\"652.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"555.0\" y=\"652.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"555.0\" y=\"404.95000000000005\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-95FD9D8A-BE26-4822-9466-F184DCBFD290\" id=\"BPMNEdge_sid-95FD9D8A-BE26-4822-9466-F184DCBFD290\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"964.4341023489249\" y=\"560.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1005.0\" y=\"560.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"1005.0\" y=\"610.0\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-1A8FC063-05B6-43DD-AE64-93DA440E06C5\" id=\"BPMNEdge_sid-1A8FC063-05B6-43DD-AE64-93DA440E06C5\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"985.5\" y=\"735.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"405.0\" y=\"735.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"405.0\" y=\"299.95000000000005\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-C002DCA6-47EE-41F1-A29E-20F0DCC98B55\" id=\"BPMNEdge_sid-C002DCA6-47EE-41F1-A29E-20F0DCC98B55\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"985.5\" y=\"945.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"405.0\" y=\"945.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"405.0\" y=\"299.95000000000005\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-76E6E361-4616-4367-BD85-AB40701429EB\" id=\"BPMNEdge_sid-76E6E361-4616-4367-BD85-AB40701429EB\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"945.5\" y=\"579.4396561135371\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"945.5\" y=\"652.0000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"250.0\" y=\"652.0000000000001\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"250.0\" y=\"209.95000000000002\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-044B91A5-E1EC-4C89-B153-EF7607AAEC57\" id=\"BPMNEdge_sid-044B91A5-E1EC-4C89-B153-EF7607AAEC57\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"945.5\" y=\"579.4396561135371\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"945.5\" y=\"652.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"405.0\" y=\"652.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"405.0\" y=\"299.95000000000005\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-980F2B68-B705-4B4E-BE1F-C67479807DF6\" id=\"BPMNEdge_sid-980F2B68-B705-4B4E-BE1F-C67479807DF6\" flowable:sourceDockerX=\"50.0\" flowable:sourceDockerY=\"40.0\" flowable:targetDockerX=\"20.5\" flowable:targetDockerY=\"20.5\">\n" +
            "        <omgdi:waypoint x=\"299.9499999999932\" y=\"170.2615183246073\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"325.3947368421047\" y=\"170.39473684210526\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-FDDA9D88-A0E6-49EA-99BD-59FEFCADE049\" id=\"BPMNEdge_sid-FDDA9D88-A0E6-49EA-99BD-59FEFCADE049\" flowable:sourceDockerX=\"50.0\" flowable:sourceDockerY=\"40.0\" flowable:targetDockerX=\"20.5\" flowable:targetDockerY=\"20.5\">\n" +
            "        <omgdi:waypoint x=\"904.9499999999829\" y=\"560.2759668508287\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"925.3888888888889\" y=\"560.3888888888889\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-E37882D3-2B49-447B-A547-01FB73556305\" id=\"BPMNEdge_sid-E37882D3-2B49-447B-A547-01FB73556305\" flowable:sourceDockerX=\"20.5\" flowable:sourceDockerY=\"20.5\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"985.5\" y=\"945.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"855.0\" y=\"945.5\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"855.0\" y=\"599.9499999999999\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge bpmnElement=\"sid-48D8ED10-FD7E-4A91-A861-C507EEF02743\" id=\"BPMNEdge_sid-48D8ED10-FD7E-4A91-A861-C507EEF02743\" flowable:sourceDockerX=\"15.0\" flowable:sourceDockerY=\"15.0\" flowable:targetDockerX=\"50.0\" flowable:targetDockerY=\"40.0\">\n" +
            "        <omgdi:waypoint x=\"39.949997146068426\" y=\"85.0\"></omgdi:waypoint>\n" +
            "        <omgdi:waypoint x=\"55.0\" y=\"85.0\"></omgdi:waypoint>\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "    </bpmndi:BPMNPlane>\n" +
            "  </bpmndi:BPMNDiagram>\n" +
            "</definitions>";

    static {
        defaultBpm.put("step-2", step2Bpm);
        defaultBpm.put("step-3", step3Bpm);
        defaultBpm.put("step-4", step4Bpm);
        defaultBpm.put("step-5", step5Bpm);
        defaultBpm.put("step-6", step6Bpm);
        defaultBpm.put("step-7", step7Bpm);
        defaultBpm.put("step-8", step8Bpm);
    }
}
