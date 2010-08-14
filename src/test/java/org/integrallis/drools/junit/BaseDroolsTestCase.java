package org.integrallis.drools.junit;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.junit.After;
import org.junit.Before;

public abstract class BaseDroolsTestCase {
	private static KnowledgeBase knowledgeBase;
	private KnowledgeRuntimeLogger logger;
	protected StatefulKnowledgeSession knowledgeSession;
	
	public BaseDroolsTestCase(String drlFile) { readRule(drlFile); }
	
	@Before
	public void setUp() throws Exception {
		knowledgeSession = knowledgeBase.newStatefulKnowledgeSession();
		logger = KnowledgeRuntimeLoggerFactory.newConsoleLogger(knowledgeSession);
	}
	
	@After
	public void tearDown() throws Exception {
		logger.close();
		knowledgeSession.dispose();
	}
	
	protected static KnowledgeBase getKnowledgeBase() {
		return knowledgeBase;
	}
	
	private static void readRule(String drlFile) {
		KnowledgeBuilder knowledgeBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		knowledgeBuilder.add(ResourceFactory.newClassPathResource(drlFile), ResourceType.DRL);
		KnowledgeBuilderErrors errors = knowledgeBuilder.getErrors();
		if (errors.size() > 0) {
			for (KnowledgeBuilderError error: errors) { System.err.println(error); }
			throw new IllegalArgumentException("Could not parse knowledge in " + drlFile);
		}
		
		knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
		knowledgeBase.addKnowledgePackages(knowledgeBuilder.getKnowledgePackages());	
	}
}
