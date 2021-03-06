/*
 * The Alluxio Open Foundation licenses this work under the Apache License, version 2.0
 * (the "License"). You may not use this work except in compliance with the License, which is
 * available at www.apache.org/licenses/LICENSE-2.0
 *
 * This software is distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied, as more fully set forth in the License.
 *
 * See the NOTICE file distributed with this work for information regarding copyright ownership.
 */

package alluxio.master;

import alluxio.master.journal.JournalSystem;

import javax.annotation.concurrent.ThreadSafe;

/**
 * Interface for factory of {@link Master}.
 */
@ThreadSafe
public interface MasterFactory {
  /**
   * @return whether the master is enabled
   */
  boolean isEnabled();

  /**
   * @return the master's name
   */
  String getName();

  /**
   * Factory method to create a new master instance.
   *
   * @param registry the master registry
   * @param journalSystem a journal system for persisting master state
   * @param safeModeManager a manager for safe mode state
   * @param startTimeMs the master process start time
   * @param port the rpc port
   * @return a new {@link Master} instance
   */
  Master create(MasterRegistry registry, JournalSystem journalSystem,
      SafeModeManager safeModeManager, long startTimeMs, int port);
}
