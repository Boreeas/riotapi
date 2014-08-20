/*
 * Copyright 2014 The LolDevs team (https://github.com/loldevs)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.boreeas.xmpp;

public enum ChatType {

	ARRANGING_PRACTICE("ap"),
	RANKED_TEAM("tm"),
	CHAMPION_SELECT1("c1"),
	CHAMPION_SELECT2("c2"),
	PRIVATE("pr"),
	ARRANGING_GAME("ag"),
	GLOBAL("gl"),
	PUBLIC("pu"),
	CAP("cp"),
	QUEUED("aq"),
	CTA("cta"),
	POST_GAME("pg");

	public final String type;

	private ChatType(String type) {
		this.type = type;
	}

	public ChatType resolve(String type) {
		for (ChatType t : values()) {
			if (t.type.equals(type)) {
				return t;
			}
		}
		return null;
	}
}
