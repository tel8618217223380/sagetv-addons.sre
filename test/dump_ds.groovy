/*
*      Copyright 2011 Battams, Derek
*
*       Licensed under the Apache License, Version 2.0 (the "License");
*       you may not use this file except in compliance with the License.
*       You may obtain a copy of the License at
*
*          http://www.apache.org/licenses/LICENSE-2.0
*
*       Unless required by applicable law or agreed to in writing, software
*       distributed under the License is distributed on an "AS IS" BASIS,
*       WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*       See the License for the specific language governing permissions and
*       limitations under the License.
*/
import sagex.SageAPI
import sagex.api.UserRecordAPI
import sagex.remote.rmi.RMISageAPI

import com.google.code.sagetvaddons.sre.plugin.SrePlugin

/*
 * Dumps the SREv4 data store to stdout
 */
SageAPI.setProvider(new RMISageAPI('192.168.1.11', 1098))

UserRecordAPI.GetAllUserRecords(SrePlugin.PLUGIN_ID).each { r ->
	print '['
	UserRecordAPI.GetUserRecordNames(r).each { name ->
		print "$name: ${UserRecordAPI.GetUserRecordData(r, name)}, "
	}
	println ']'
}