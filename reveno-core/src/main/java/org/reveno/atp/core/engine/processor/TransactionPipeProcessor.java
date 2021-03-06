/** 
 *  Copyright (c) 2015 The original author or authors
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0

 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.reveno.atp.core.engine.processor;

import org.reveno.atp.api.commands.EmptyResult;
import org.reveno.atp.api.commands.Result;
import org.reveno.atp.core.api.Destroyable;
import org.reveno.atp.core.api.RestoreableEventBus;
import org.reveno.atp.core.api.TransactionCommitInfo;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface TransactionPipeProcessor<T extends Destroyable> extends PipeProcessor<T> {

	CompletableFuture<EmptyResult> process(List<Object> commands);
	
	<R> CompletableFuture<Result<R>> execute(Object command);
	
	void executeRestore(RestoreableEventBus eventBus, TransactionCommitInfo transaction);
	
}
