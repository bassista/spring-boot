/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.bootstrap.service.audit;

import java.util.Date;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dave Syer
 * 
 */
public class InMemoryAuditEventRepositoryTests {

	private InMemoryAuditEventRepository repository = new InMemoryAuditEventRepository();

	@Test
	public void testAddToCapacity() throws Exception {
		this.repository.setCapacity(2);
		this.repository.add(new AuditEvent("phil", "UNKNOWN"));
		this.repository.add(new AuditEvent("phil", "UNKNOWN"));
		this.repository.add(new AuditEvent("dave", "UNKNOWN"));
		this.repository.add(new AuditEvent("dave", "UNKNOWN"));
		this.repository.add(new AuditEvent("phil", "UNKNOWN"));
		assertEquals(2, this.repository.find("phil", new Date(0L)).size());
	}

}