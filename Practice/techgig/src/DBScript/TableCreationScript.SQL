Create Database MRBookingApp;

Create Table MRBookingApp.meetingRoomType
	(mRTypeId int not null AUTO_INCREMENT,
         type int,
	 primary key(mRTypeId));

Create Table MRBookingApp.RoomDetail
	(roomId int not null AUTO_INCREMENT,
	 roomName varchar(255),
	building varchar(255),
	floor int,
	mRTypeId int,
	Primary key(roomId),
	Foreign key(mRTypeId) references meetingRoomType(mRTypeId));

Create Table MRBookingApp.BookingDetail
	(bId int not null AUTO_INCREMENT,
	 bookingName varchar(255),
	roomId int,
	referenceId varchar(255),
	status varchar(255),
	bookedDateTimeTo dateTime,
	bookedDateTimeFrom dateTime,

	primary key(bId),
	Foreign key(roomId) references RoomDetail(roomId));

