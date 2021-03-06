/*
 * Copyright 2005-2014 Red Hat, Inc.
 * Red Hat licenses this file to you under the Apache License, version
 * 2.0 (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 */
package org.hornetq.core.server;

import java.util.List;
import java.util.Map;

import org.hornetq.api.core.SimpleString;
import org.hornetq.core.transaction.Transaction;

/**
 * A RoutingContext
 *
 * @author Tim Fox
 * @author Clebert Suconic
 *
 *
 */
public interface RoutingContext
{
   Transaction getTransaction();

   void setTransaction(Transaction transaction);

   void addQueue(SimpleString address, Queue queue);

   Map<SimpleString, RouteContextList> getContexListing();

   RouteContextList getContextListing(SimpleString address);

   List<Queue> getNonDurableQueues(SimpleString address);

   List<Queue> getDurableQueues(SimpleString address);

   int getQueueCount();

   void clear();



}
