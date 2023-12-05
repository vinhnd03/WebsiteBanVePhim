USE [master]
GO
CREATE DATABASE [QLRP]
GO
USE [QLRP]
GO
/****** Object:  Table [dbo].[Accounts]    Script Date: 12/5/2023 8:54:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Accounts](
	[Username] [nvarchar](30) NOT NULL,
	[Password] [nvarchar](30) NULL,
	[Name] [nvarchar](50) NULL,
	[Email] [nvarchar](50) NULL,
	[Sdt] [nvarchar](10) NULL,
	[Gender] [bit] NULL,
	[Address] [nvarchar](150) NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Authorities]    Script Date: 12/5/2023 8:54:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Authorities](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Username] [nvarchar](30) NULL,
	[RoleId] [nvarchar](10) NULL,
 CONSTRAINT [PK_PhanQuyen] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 12/5/2023 8:54:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](30) NULL,
 CONSTRAINT [PK_TheLoaiPhim] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Movies]    Script Date: 12/5/2023 8:54:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Movies](
	[Id] [bigint] IDENTITY(1,1) NOT NULL,
	[CategoryId] [int] NULL,
	[Name] [nvarchar](50) NULL,
	[Country] [nvarchar](50) NULL,
	[Age] [int] NULL,
	[ReleaseDate] [datetime] NULL,
	[Poster] [nvarchar](100) NULL,
	[Description] [nvarchar](50) NULL,
	[MovieContent] [nvarchar](500) NULL,
	[Duration] [int] NULL,
	[Trailer] [nvarchar](100) NULL,
 CONSTRAINT [PK_Phim] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderDetails]    Script Date: 12/5/2023 8:54:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetails](
	[Id] [bigint] IDENTITY(1,1) NOT NULL,
	[TypeId] [int] NULL,
	[TicketId] [bigint] NULL,
	[SeatId] [int] NULL,
	[OrderId] [bigint] NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Orders]    Script Date: 12/5/2023 8:54:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[Id] [bigint] IDENTITY(1,1) NOT NULL,
	[CreateDate] [date] NULL,
	[Username] [nvarchar](30) NULL,
	[Email] [nvarchar](50) NULL,
 CONSTRAINT [PK_Orders] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Roles]    Script Date: 12/5/2023 8:54:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Roles](
	[Id] [nvarchar](10) NOT NULL,
	[Name] [nvarchar](20) NULL,
 CONSTRAINT [PK_VaiTro] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Rooms]    Script Date: 12/5/2023 8:54:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Rooms](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
 CONSTRAINT [PK_PhongChieu] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Seats]    Script Date: 12/5/2023 8:54:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Seats](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[RoomId] [int] NULL,
 CONSTRAINT [PK_Seats] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tickets]    Script Date: 12/5/2023 8:54:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tickets](
	[Id] [bigint] IDENTITY(1,1) NOT NULL,
	[Date] [date] NULL,
	[RoomId] [int] NULL,
	[MovieId] [bigint] NOT NULL,
	[Time] [time](7) NULL,
	[Price] [float] NULL,
	[Available] [bit] NULL,
 CONSTRAINT [PK_Ve] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TicketTypes]    Script Date: 12/5/2023 8:54:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TicketTypes](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Price] [float] NULL,
 CONSTRAINT [PK_LoaiVe] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Accounts] ([Username], [Password], [Name], [Email], [Sdt], [Gender], [Address]) VALUES (N'admin', N'12345', N'Nguyễn Đức Vĩnh', N'vinhndpd05706@fpt.edu.vn', N'0766536921', 1, N'mỹ tho')
GO
INSERT [dbo].[Accounts] ([Username], [Password], [Name], [Email], [Sdt], [Gender], [Address]) VALUES (N'staff', N'12345', N'Nguyễn Mạnh Trường', N'truong@gmail.com', N'0987654321', 1, N'home')
GO
INSERT [dbo].[Accounts] ([Username], [Password], [Name], [Email], [Sdt], [Gender], [Address]) VALUES (N'test', N'123', N'ABC', N'hoang@gmail.com', N'0123456789', 1, N'abc')
GO
INSERT [dbo].[Accounts] ([Username], [Password], [Name], [Email], [Sdt], [Gender], [Address]) VALUES (N'vinh', N'123', N'Nguyen Duc Vinh', N'Vinnh@gmail.com', N'0123456789', 1, N'Nhan vien')
GO
SET IDENTITY_INSERT [dbo].[Authorities] ON 
GO
INSERT [dbo].[Authorities] ([Id], [Username], [RoleId]) VALUES (1, N'admin', N'ADMIN')
GO
INSERT [dbo].[Authorities] ([Id], [Username], [RoleId]) VALUES (2, N'test', N'USER')
GO
INSERT [dbo].[Authorities] ([Id], [Username], [RoleId]) VALUES (3, N'staff', N'STAFF')
GO
SET IDENTITY_INSERT [dbo].[Authorities] OFF
GO
SET IDENTITY_INSERT [dbo].[Categories] ON 
GO
INSERT [dbo].[Categories] ([Id], [Name]) VALUES (1, N'HÀNH ĐỘNG')
GO
INSERT [dbo].[Categories] ([Id], [Name]) VALUES (2, N'KINH DỊ')
GO
INSERT [dbo].[Categories] ([Id], [Name]) VALUES (3, N'HÀI HƯỚC')
GO
SET IDENTITY_INSERT [dbo].[Categories] OFF
GO
SET IDENTITY_INSERT [dbo].[Movies] ON 
GO
INSERT [dbo].[Movies] ([Id], [CategoryId], [Name], [Country], [Age], [ReleaseDate], [Poster], [Description], [MovieContent], [Duration], [Trailer]) VALUES (1, 1, N'BIỆT ĐỘI ĐÁNH THUÊ', N'Mỹ', 18, CAST(N'2023-11-02T00:00:00.000' AS DateTime), N'1700924082865_4a902087-797f-485d-b51b-8e4467851295.jpg', N'abc', N'Biệt Đội Đánh Thuê - gồm cả các gương mặt kỳ cựu và những tân binh - đã bắt đầu một nhiệm vụ mới. Lần này, họ sẽ tới một nhà máy vũ khí hạt nhân cũ tại Qadhafi để tóm gọn Suharato Rahmat, kẻ đang âm mưu một mình đánh cắp kíp nổ hạt nhân cho gã khách hàng xảo quyệt Ocelot,...', 300, NULL)
GO
INSERT [dbo].[Movies] ([Id], [CategoryId], [Name], [Country], [Age], [ReleaseDate], [Poster], [Description], [MovieContent], [Duration], [Trailer]) VALUES (2, 1, N'ÁN MẠNG VENICE', N'Mỹ', 18, CAST(N'2023-11-01T00:00:00.000' AS DateTime), N'1700924102259_f37a07c4-b611-43cc-85d9-1e207afe52c6.jpg', N'ABC', N'Dựa trên tiểu thuyết Hallowe''en Party của nhà văn Agatha Christie, hành trình phá án của thám tử Hercule Poirot tiếp tục được đưa lên màn ảnh rộng.', 200, NULL)
GO
INSERT [dbo].[Movies] ([Id], [CategoryId], [Name], [Country], [Age], [ReleaseDate], [Poster], [Description], [MovieContent], [Duration], [Trailer]) VALUES (3, 2, N'ĐƠN HÀNG TỪ SÁT NHÂN', N'Mỹ', 18, CAST(N'2023-11-01T00:00:00.000' AS DateTime), N'1700924117781_65c0ec79-c5da-4fd6-b7f1-483b7bc1d674.jpg', N'ABC', N'Đơn Hàng Từ Sát Nhân (Don''t Buy The Seller) là một bộ phim chiếu rạp Hàn Quốc thuộc thể loại kinh dị, tội phạm của đạo diễn Park Hee Kon. Phim này, sẽ đem đến cho người xem một câu chuyện kể về một kẻ giết người hàng loạt biến thái sử dụng app mua bán đồ secondhand để tìm kiếm con mồi,...', 200, NULL)
GO
INSERT [dbo].[Movies] ([Id], [CategoryId], [Name], [Country], [Age], [ReleaseDate], [Poster], [Description], [MovieContent], [Duration], [Trailer]) VALUES (4, 2, N'HỌA QUỶ', N'Vietnam', 18, CAST(N'2023-11-01T00:00:00.000' AS DateTime), N'1700924136163_4f81f49b-2594-4def-8b19-fbdfe7067622.jpg', N'HỌA QUỶ', N'Nhà khoa học thiên tài Tomohiko Kataoka được trưởng nhóm nghiên cứu Synthekai VR yêu cầu tham gia cùng họ trên Đảo Abominable. Ở đó, họ đã tạo ra một không gian ảo cho toàn bộ hòn đảo và họ muốn Tomohiko sử dụng các kỹ thuật tiên tiến của mình để nâng cấp dự án,..', 5, NULL)
GO
INSERT [dbo].[Movies] ([Id], [CategoryId], [Name], [Country], [Age], [ReleaseDate], [Poster], [Description], [MovieContent], [Duration], [Trailer]) VALUES (5, 1, N'BÍ MẬT DUMBLEDORF', N'Mỹ', 15, CAST(N'2023-11-03T00:00:00.000' AS DateTime), N'1700924154613_8919ac02-d489-497a-bde3-79417baabf9f.jpg', N'ABC', N'Cùng nhau khám phá những bí mật, những câu chuyện chưa được kể của thầy Albus Dumbledore và kế hoạch ngăn chặn cuộc nổi loạn của Gellert Grindelwald trong phần 3 Sinh Vật Huyền Bí.', 333, NULL)
GO
INSERT [dbo].[Movies] ([Id], [CategoryId], [Name], [Country], [Age], [ReleaseDate], [Poster], [Description], [MovieContent], [Duration], [Trailer]) VALUES (6, 3, N'SIÊU LỪA GẶP SIÊU QUẬY', N'Vietnam', 18, CAST(N'2023-11-01T00:00:00.000' AS DateTime), N'1700924176000_921ae7b7-727f-4105-82e1-fab2bd4ba311.webp', NULL, N'Thuộc phong cách hành động – hài hước với các “cú lừa” thông minh và lầy lội đến từ bộ đôi Tú (Anh Tú) và Khoa (Mạc Văn Khoa), Siêu Lừa Gặp Siêu Lầy của đạo diễn Võ Thanh Hòa theo chân của Khoa – tên lừa đảo tầm cỡ “quốc nội” đến đảo ngọc Phú Quốc với mong muốn đổi đời....', 121, NULL)
GO
INSERT [dbo].[Movies] ([Id], [CategoryId], [Name], [Country], [Age], [ReleaseDate], [Poster], [Description], [MovieContent], [Duration], [Trailer]) VALUES (7, 3, N'TẤM VÉ ĐỊNH MỆNH', N'Vietnam', 15, CAST(N'2023-11-01T00:00:00.000' AS DateTime), N'1700924187587_e082432c-8d37-4ab5-a481-0a0f3a76b6af.jpg', NULL, N'Nội dung phim kể về tấm vé có mệnh giá 10 ngàn đồng và sở hữu những con số "định mệnh" gồm 10, 16, 18, 20, 27, 28 - đây là tập hợp những con số ngày sinh của hội bạn thân gồm 6 người. Câu chuyện bắt đầu khi cả 6 người bạn thân quyết định mua một tấm vé số có dãy số là tập hợp ngày sinh của cả 6 người,..', 133, NULL)
GO
INSERT [dbo].[Movies] ([Id], [CategoryId], [Name], [Country], [Age], [ReleaseDate], [Poster], [Description], [MovieContent], [Duration], [Trailer]) VALUES (8, 2, N'LIVE', N'MỸ', 18, CAST(N'2023-11-02T00:00:00.000' AS DateTime), N'1700924205437_4db86d3c-354b-4382-927e-7528db7f8267.jpg', NULL, N'Bộ phim Việt đầu tiên trực diện nói về vấn đề bạo lực mạng xã hội. Câu chuyện xoay quanh hai người trẻ đầy tham vọng, bất chấp tất cả để có thể trở nên nổi tiếng trên mạng. Họ dùng đủ cách thức lẫn chiêu trò để đạt được mục đích của mình, cho đến khi chính bản thân họ lại thành con mồi mới cho những kẻ trên mạng, những người sẵn sàng lao vào tấn công người khác chỉ vì “Không ưa con đó,...', NULL, NULL)
GO
INSERT [dbo].[Movies] ([Id], [CategoryId], [Name], [Country], [Age], [ReleaseDate], [Poster], [Description], [MovieContent], [Duration], [Trailer]) VALUES (9, 1, N'ĐẤT RỪNG PHƯƠNG NAM', N'Vietnam', 18, CAST(N'2023-11-01T00:00:00.000' AS DateTime), N'1700924229184_93ffdcc9-af23-4874-9a71-6b33d06c2885.jpg', NULL, N'Đất Rừng Phương Nam phiên bản điện ảnh được kế thừa và phát triển từ tiểu thuyết cùng tên của nhà văn Đoàn Giỏi. Bộ phim kể về hành trình phiêu lưu của An - một cậu bé chẳng may mất mẹ trên đường đi tìm cha. Cùng với An, khán giả sẽ trải nghiệm sự trù phú của thiên nhiên và nét đẹp văn hoá đặc sắc của vùng đất Nam Kì Lục Tỉnh,.', NULL, NULL)
GO
INSERT [dbo].[Movies] ([Id], [CategoryId], [Name], [Country], [Age], [ReleaseDate], [Poster], [Description], [MovieContent], [Duration], [Trailer]) VALUES (10, 1, N'SOMETHING', N'MỸ', 16, CAST(N'2023-11-02T00:00:00.000' AS DateTime), N'1700924242523_9319b762-f5e4-4343-8e24-96587782d2a6.jpg', NULL, N'Đề tài tình yêu luôn có nhiều khoảng sân để các biên kịch khai thác, và Something in the rain (Chị đẹp mua cơm cho tôi ăn) đã chiếm được một khoảng đẹp và “đáng tiền”. Không tạo cho khán giả cảm giác đây là chuyện tình viễn tưởng chỉ có trong cổ tích,,..', 122, NULL)
GO
SET IDENTITY_INSERT [dbo].[Movies] OFF
GO
SET IDENTITY_INSERT [dbo].[OrderDetails] ON 
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (10, NULL, 11, 75, 1)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (11, NULL, 11, 65, 1)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (12, NULL, 10, 106, 2)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (13, NULL, 10, 116, 2)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (14, NULL, 4, 140, 3)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (15, NULL, 4, 130, 3)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (16, NULL, 4, 120, 3)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (17, NULL, 10, 140, 4)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (18, NULL, 10, 130, 5)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (19, NULL, 10, 10, 6)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (20, NULL, 10, 10, 7)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (21, NULL, 2, 129, 9)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (22, NULL, 2, 128, 9)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (23, NULL, 2, 140, 9)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (24, NULL, 2, 138, 9)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (25, NULL, 2, 139, 9)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (26, NULL, 2, 127, 9)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (27, NULL, 2, 137, 10)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (28, NULL, 2, 125, 10)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (29, NULL, 2, 135, 10)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (30, NULL, 2, 136, 10)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (31, NULL, 2, 126, 10)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (32, NULL, 2, 124, 10)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (33, NULL, 2, 134, 10)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (34, NULL, 2, 133, 10)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (35, NULL, 2, 130, 11)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (36, NULL, 2, 119, 11)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (37, NULL, 2, 120, 11)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (38, NULL, 2, 121, 12)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (39, NULL, 2, 131, 12)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (40, NULL, 2, 111, 12)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (41, NULL, 2, 122, 12)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (42, NULL, 2, 123, 12)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (43, NULL, 2, 113, 12)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (44, NULL, 2, 112, 12)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (45, NULL, 2, 132, 12)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (46, NULL, 1, 140, 14)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (47, NULL, 1, 130, 14)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (48, NULL, 1, 120, 14)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (49, NULL, 1, 138, 15)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (50, NULL, 1, 118, 15)
GO
INSERT [dbo].[OrderDetails] ([Id], [TypeId], [TicketId], [SeatId], [OrderId]) VALUES (51, NULL, 1, 128, 15)
GO
SET IDENTITY_INSERT [dbo].[OrderDetails] OFF
GO
SET IDENTITY_INSERT [dbo].[Orders] ON 
GO
INSERT [dbo].[Orders] ([Id], [CreateDate], [Username], [Email]) VALUES (1, CAST(N'2023-11-22' AS Date), N'admin', NULL)
GO
INSERT [dbo].[Orders] ([Id], [CreateDate], [Username], [Email]) VALUES (2, CAST(N'2023-11-29' AS Date), N'admin', NULL)
GO
INSERT [dbo].[Orders] ([Id], [CreateDate], [Username], [Email]) VALUES (3, CAST(N'2023-12-03' AS Date), N'admin', NULL)
GO
INSERT [dbo].[Orders] ([Id], [CreateDate], [Username], [Email]) VALUES (4, CAST(N'2023-12-03' AS Date), N'admin', NULL)
GO
INSERT [dbo].[Orders] ([Id], [CreateDate], [Username], [Email]) VALUES (5, CAST(N'2023-12-03' AS Date), N'admin', NULL)
GO
INSERT [dbo].[Orders] ([Id], [CreateDate], [Username], [Email]) VALUES (6, CAST(N'2023-12-03' AS Date), N'admin', NULL)
GO
INSERT [dbo].[Orders] ([Id], [CreateDate], [Username], [Email]) VALUES (7, CAST(N'2023-12-03' AS Date), N'admin', NULL)
GO
INSERT [dbo].[Orders] ([Id], [CreateDate], [Username], [Email]) VALUES (8, CAST(N'2023-12-04' AS Date), N'admin', NULL)
GO
INSERT [dbo].[Orders] ([Id], [CreateDate], [Username], [Email]) VALUES (9, CAST(N'2023-12-04' AS Date), N'admin', NULL)
GO
INSERT [dbo].[Orders] ([Id], [CreateDate], [Username], [Email]) VALUES (10, CAST(N'2023-12-04' AS Date), N'admin', NULL)
GO
INSERT [dbo].[Orders] ([Id], [CreateDate], [Username], [Email]) VALUES (11, CAST(N'2023-12-04' AS Date), N'admin', NULL)
GO
INSERT [dbo].[Orders] ([Id], [CreateDate], [Username], [Email]) VALUES (12, CAST(N'2023-12-04' AS Date), N'admin', NULL)
GO
INSERT [dbo].[Orders] ([Id], [CreateDate], [Username], [Email]) VALUES (13, CAST(N'2023-12-04' AS Date), N'admin', NULL)
GO
INSERT [dbo].[Orders] ([Id], [CreateDate], [Username], [Email]) VALUES (14, CAST(N'2023-12-04' AS Date), N'admin', NULL)
GO
INSERT [dbo].[Orders] ([Id], [CreateDate], [Username], [Email]) VALUES (15, CAST(N'2023-12-04' AS Date), N'admin', NULL)
GO
SET IDENTITY_INSERT [dbo].[Orders] OFF
GO
INSERT [dbo].[Roles] ([Id], [Name]) VALUES (N'ADMIN', N'QuanTri')
GO
INSERT [dbo].[Roles] ([Id], [Name]) VALUES (N'STAFF', N'NhanVien')
GO
INSERT [dbo].[Roles] ([Id], [Name]) VALUES (N'USER', N'NguoiDung')
GO
SET IDENTITY_INSERT [dbo].[Rooms] ON 
GO
INSERT [dbo].[Rooms] ([Id], [Name]) VALUES (1, N'P001')
GO
INSERT [dbo].[Rooms] ([Id], [Name]) VALUES (2, N'P002')
GO
INSERT [dbo].[Rooms] ([Id], [Name]) VALUES (3, N'P003')
GO
INSERT [dbo].[Rooms] ([Id], [Name]) VALUES (4, N'P004')
GO
SET IDENTITY_INSERT [dbo].[Rooms] OFF
GO
SET IDENTITY_INSERT [dbo].[Seats] ON 
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (1, N'A1', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (2, N'A2', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (3, N'A3', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (4, N'A4', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (5, N'A5', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (6, N'A6', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (7, N'A7', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (8, N'A8', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (9, N'A9', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (10, N'A10', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (11, N'B1', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (12, N'B2', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (13, N'B3', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (14, N'B4', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (15, N'B5', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (16, N'B6', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (17, N'B7', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (18, N'B8', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (19, N'B9', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (20, N'B10', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (21, N'C1', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (22, N'C2', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (23, N'C3', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (24, N'C4', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (25, N'C5', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (26, N'C6', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (27, N'C7', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (28, N'C8', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (29, N'C9', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (30, N'C10', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (31, N'D1', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (32, N'D2', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (33, N'D3', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (34, N'D4', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (35, N'D5', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (36, N'D6', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (37, N'D7', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (38, N'D8', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (39, N'D9', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (40, N'D10', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (41, N'E1', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (42, N'E2', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (43, N'E3', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (44, N'E4', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (45, N'E5', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (46, N'E6', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (47, N'E7', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (48, N'E8', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (49, N'E9', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (50, N'E10', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (51, N'F1', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (52, N'F2', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (53, N'F3', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (54, N'F4', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (55, N'F5', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (56, N'F6', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (57, N'F7', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (58, N'F8', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (59, N'F9', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (60, N'F10', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (61, N'G1', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (62, N'G2', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (63, N'G3', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (64, N'G4', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (65, N'G5', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (66, N'G6', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (67, N'G7', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (68, N'G8', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (69, N'G9', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (70, N'G10', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (71, N'H1', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (72, N'H2', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (73, N'H3', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (74, N'H4', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (75, N'H5', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (76, N'H6', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (77, N'H7', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (78, N'H8', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (79, N'H9', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (80, N'H10', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (81, N'I1', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (82, N'I2', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (83, N'I3', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (84, N'I4', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (85, N'I5', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (86, N'I6', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (87, N'I7', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (88, N'I8', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (89, N'I9', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (90, N'I10', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (91, N'J1', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (92, N'J2', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (93, N'J3', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (94, N'J4', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (95, N'J5', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (96, N'J6', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (97, N'J7', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (98, N'J8', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (99, N'J9', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (100, N'J10', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (101, N'K1', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (102, N'K2', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (103, N'K3', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (104, N'K4', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (105, N'K5', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (106, N'K6', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (107, N'K7', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (108, N'K8', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (109, N'K9', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (110, N'K10', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (111, N'L1', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (112, N'L2', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (113, N'L3', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (114, N'L4', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (115, N'L5', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (116, N'L6', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (117, N'L7', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (118, N'L8', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (119, N'L9', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (120, N'L10', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (121, N'M1', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (122, N'M2', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (123, N'M3', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (124, N'M4', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (125, N'M5', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (126, N'M6', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (127, N'M7', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (128, N'M8', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (129, N'M9', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (130, N'M10', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (131, N'N1', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (132, N'N2', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (133, N'N3', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (134, N'N4', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (135, N'N5', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (136, N'N6', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (137, N'N7', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (138, N'N8', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (139, N'N9', 1)
GO
INSERT [dbo].[Seats] ([Id], [Name], [RoomId]) VALUES (140, N'N10', 1)
GO
SET IDENTITY_INSERT [dbo].[Seats] OFF
GO
SET IDENTITY_INSERT [dbo].[Tickets] ON 
GO
INSERT [dbo].[Tickets] ([Id], [Date], [RoomId], [MovieId], [Time], [Price], [Available]) VALUES (1, CAST(N'2023-11-15' AS Date), 1, 1, CAST(N'16:55:00' AS Time), 50000, 1)
GO
INSERT [dbo].[Tickets] ([Id], [Date], [RoomId], [MovieId], [Time], [Price], [Available]) VALUES (2, CAST(N'2023-11-27' AS Date), 2, 2, CAST(N'00:12:00' AS Time), 33000, 1)
GO
INSERT [dbo].[Tickets] ([Id], [Date], [RoomId], [MovieId], [Time], [Price], [Available]) VALUES (3, CAST(N'2023-11-22' AS Date), 4, 3, CAST(N'21:14:00' AS Time), 55000, 1)
GO
INSERT [dbo].[Tickets] ([Id], [Date], [RoomId], [MovieId], [Time], [Price], [Available]) VALUES (4, CAST(N'2023-11-27' AS Date), 3, 8, CAST(N'23:08:00' AS Time), 120000, 1)
GO
INSERT [dbo].[Tickets] ([Id], [Date], [RoomId], [MovieId], [Time], [Price], [Available]) VALUES (5, CAST(N'2023-11-28' AS Date), 2, 8, CAST(N'22:09:00' AS Time), 12000, 1)
GO
INSERT [dbo].[Tickets] ([Id], [Date], [RoomId], [MovieId], [Time], [Price], [Available]) VALUES (6, CAST(N'2023-11-13' AS Date), 4, 8, CAST(N'14:10:00' AS Time), 120000, 1)
GO
INSERT [dbo].[Tickets] ([Id], [Date], [RoomId], [MovieId], [Time], [Price], [Available]) VALUES (7, CAST(N'2023-11-22' AS Date), 2, 4, CAST(N'02:25:00' AS Time), 56000, 1)
GO
INSERT [dbo].[Tickets] ([Id], [Date], [RoomId], [MovieId], [Time], [Price], [Available]) VALUES (8, CAST(N'2023-11-22' AS Date), 3, 5, CAST(N'21:21:00' AS Time), 23000, 1)
GO
INSERT [dbo].[Tickets] ([Id], [Date], [RoomId], [MovieId], [Time], [Price], [Available]) VALUES (9, CAST(N'2023-11-22' AS Date), 2, 5, CAST(N'13:26:00' AS Time), 56000, 1)
GO
INSERT [dbo].[Tickets] ([Id], [Date], [RoomId], [MovieId], [Time], [Price], [Available]) VALUES (10, CAST(N'2023-11-24' AS Date), 2, 1, CAST(N'01:27:00' AS Time), 56000, 1)
GO
INSERT [dbo].[Tickets] ([Id], [Date], [RoomId], [MovieId], [Time], [Price], [Available]) VALUES (11, CAST(N'2023-11-22' AS Date), 1, 10, CAST(N'09:29:00' AS Time), 56000, 1)
GO
INSERT [dbo].[Tickets] ([Id], [Date], [RoomId], [MovieId], [Time], [Price], [Available]) VALUES (12, CAST(N'2023-11-26' AS Date), 1, 1, CAST(N'20:39:31.3800000' AS Time), 40000, 1)
GO
INSERT [dbo].[Tickets] ([Id], [Date], [RoomId], [MovieId], [Time], [Price], [Available]) VALUES (13, CAST(N'2023-11-27' AS Date), 1, 1, CAST(N'20:40:00' AS Time), 90000, 1)
GO
INSERT [dbo].[Tickets] ([Id], [Date], [RoomId], [MovieId], [Time], [Price], [Available]) VALUES (14, CAST(N'2023-11-26' AS Date), 2, 1, CAST(N'14:06:00' AS Time), 45000, 1)
GO
SET IDENTITY_INSERT [dbo].[Tickets] OFF
GO
ALTER TABLE [dbo].[Authorities]  WITH CHECK ADD  CONSTRAINT [FK_PhanQuyen_TaiKhoan] FOREIGN KEY([Username])
REFERENCES [dbo].[Accounts] ([Username])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Authorities] CHECK CONSTRAINT [FK_PhanQuyen_TaiKhoan]
GO
ALTER TABLE [dbo].[Authorities]  WITH CHECK ADD  CONSTRAINT [FK_PhanQuyen_VaiTro] FOREIGN KEY([RoleId])
REFERENCES [dbo].[Roles] ([Id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Authorities] CHECK CONSTRAINT [FK_PhanQuyen_VaiTro]
GO
ALTER TABLE [dbo].[Movies]  WITH CHECK ADD  CONSTRAINT [FK_Phim_TheLoaiPhim] FOREIGN KEY([CategoryId])
REFERENCES [dbo].[Categories] ([Id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Movies] CHECK CONSTRAINT [FK_Phim_TheLoaiPhim]
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetails_Orders] FOREIGN KEY([OrderId])
REFERENCES [dbo].[Orders] ([Id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[OrderDetails] CHECK CONSTRAINT [FK_OrderDetails_Orders]
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD  CONSTRAINT [FK_Orders_Seats] FOREIGN KEY([SeatId])
REFERENCES [dbo].[Seats] ([Id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[OrderDetails] CHECK CONSTRAINT [FK_Orders_Seats]
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD  CONSTRAINT [FK_Orders_Tickets] FOREIGN KEY([TicketId])
REFERENCES [dbo].[Tickets] ([Id])
GO
ALTER TABLE [dbo].[OrderDetails] CHECK CONSTRAINT [FK_Orders_Tickets]
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD  CONSTRAINT [FK_Orders_TicketTypes] FOREIGN KEY([TypeId])
REFERENCES [dbo].[TicketTypes] ([Id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[OrderDetails] CHECK CONSTRAINT [FK_Orders_TicketTypes]
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD  CONSTRAINT [FK_Orders_Accounts] FOREIGN KEY([Username])
REFERENCES [dbo].[Accounts] ([Username])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Orders] CHECK CONSTRAINT [FK_Orders_Accounts]
GO
ALTER TABLE [dbo].[Seats]  WITH CHECK ADD  CONSTRAINT [FK_Seats_Rooms] FOREIGN KEY([RoomId])
REFERENCES [dbo].[Rooms] ([Id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Seats] CHECK CONSTRAINT [FK_Seats_Rooms]
GO
ALTER TABLE [dbo].[Tickets]  WITH CHECK ADD  CONSTRAINT [FK_Tickets_Movies] FOREIGN KEY([MovieId])
REFERENCES [dbo].[Movies] ([Id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Tickets] CHECK CONSTRAINT [FK_Tickets_Movies]
GO
ALTER TABLE [dbo].[Tickets]  WITH CHECK ADD  CONSTRAINT [FK_Tickets_Rooms] FOREIGN KEY([RoomId])
REFERENCES [dbo].[Rooms] ([Id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Tickets] CHECK CONSTRAINT [FK_Tickets_Rooms]
GO
