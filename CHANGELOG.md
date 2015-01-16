# Changelog
---------
### 1.5.5
##### Xmpp
* Added toString() to RiotStatus that encodes the status in a XMPP-compatible presence format

##### Domain
* Added bot difficulty constants
* Added queue id constants
* Added missing classes for game invitations
* Added missing game modes
* Added queue type and queue id for the new custom game mode, nemesis pick

##### Rtmp
* Fixed bug where bot game invites would not pass the queue id
* Added Javadoc to LcdsGameInvitationService
* Made RtmpClient autocloseable
* Added automatic heartbeats to RtmpClient

### 1.5.4
##### General
* Unified sibling dependencies via ${project.version}

##### Xmpp
* Renamed field user and its getters to username since that was conflicting with getUser() from the superclass.

##### Spectator
* Added compression method to SpectatedGame and encryption method to GameEncryptionData to mirror decompression and decryption

### 1.5.3
##### General
* Fixed several versioning problems in the pom

##### Domain
* Updated several spectator URLs
* Updated the region tags for LAN and LAS, which were renamed to LA1 and LA2
* Added altNames to shards. This list is being maintained manually for now
* Added generic Shard.get that matches on shard region name, shard spectator platform and any of the alt names
* Shard getters now throw ShardNotFoundException if no shard with that name was found
* Added field "previousSeasonHighestTeamReward" to Summoner
* Added multiple fields to the dynamic client configuration sent at RTMP login
* Added missing constants to QueueType, GameType, GameMode

##### RTMP
* Improved exception handling
* Fixed UTF-8 encoding error

##### Login Queue
* Now always runs at least once, even if a timeout occurs before


### 1.5.2
##### Domain
* Added missing fields to GameDto

##### Rest
* Updated team to v2.4. Apologies, this should've been in v1.3.0

### 1.5.1
##### Spectator
* Fixed a bug where failing to pull a keyframe or chunk would crash GameUpdateTask

### 1.5.0
##### Domain
* Added getByName to Shard

##### Rtmp
* Added support for ignoring SSL certificate chain errors.
* Added missing fields: LoginDataPacket.restrictedGamesRemainingForRanked, LeagueList.nextApexUpdate, LeagueList.maxLeagueSize

##### Rest
* Added support for Status v1.0
* Added summoner id to ParticipantPlayer
* Added runes and masteries to Participant
* Added match game and mode to Match
* Added dominion victory score to PostMatchTeamOverview
* Added missing fields and constants for the Ascension Event

##### Spectator
* GameUpdateTask now supports callbacks for failed chunks and keyframes
* GameUpdateTask now supports multiple callbacks per event
* Deprecated: setOnError, setOnFinished, setOnChunkPulled, setOnKeyframePulled (use add* instead)
* InProgressGame now adds the encryption key to the metadata if it isn't transmitted by the server

### 1.4.0
##### Spectator
* GamePool.submit() now returns GameUpdateTask
* Added callbacks to GameUpdateTask for received chunks, received keyframes and when the game is finished

## 1.3.0
##### Domain
* Bugfix: Fixed incorrect chat urls for the Vietnam and Indonesian regions 
* Added fallback loading of older versions.

##### Rtmp
* Bugfix: Closing RtmpClient now also closes the underlying writer thread instead of just interrupting it

##### Rest
* Updated league to v2.5
* Added support for gzip-encoding
* Added new filter options for matchhistory calls
* Added new event types for match timelines
* Bugfix: Removed double API call in getMatch()

##### Spectator
* Deprecated singleton constructor of GamePool due to its inability to return running tasks.
* Added callbacks to interface with GameUpdateTask: onChunkPulled, onKeyframePulled, onFinished

## 1.2.0
##### Domain
* Dynamic loading for shard constants
* Removed: Shard.baseUrl
* Bugfix: Added missing Participant subclasses
* Bugfix: Fixed bug where extra spaces at the end of Shard constants resulted in illegal URIs

## 1.1.0
##### Domain
* Bugfix: Fixed wrong REST Api URLs

##### Rest
* Added support for match-v2.2
* Added support for matchhistory-v2.2
* Bugfixes: Various wrong endpoints and bad field types

------

## 1.0.0
* Initial release
