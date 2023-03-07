主要功能：使用dao设计模式将用户登录功能实现


Java类：com.wanhailiang包
JavaBean：数据模型
	User：用户数据模型
		String username
		String pwd
		int age
DBConnection：处理数据库连接
	DBConnection
		static Connection getConnection()				获取DB连接实例
		static void close()								断开和DB的连接
dao：数据库操作接口类
	UserDao
		int insert()									插入用户信息
		User select()									查询用户信息
daoImpl：数据库操作实现类
	UserDaoImpl
service：业务层，将对数据库的操作封装成业务
	UserService
		void service()									业务
servlet：结合Http请求/响应处理业务
	UserServlet
		doPost(HttpServletRequest, HttpServletResponse)	doPost方法

jsp/html资源
	login.jsp：welcome页。登录功能。登陆成功跳转到index.jsp，登录失败则不跳转，显示错误信息。具有注册功能。
	register.jsp：注册页面。只有login.jsp才可以跳转到这个页面。
	index.jsp：一个只有提示信息的页，表示已经登录成功的用户可以跳转到的页面。没有登录的用户是不可以访问的。
	
数据库表：
	数据库：db_user
		表：userinfo：表示用户信息
		VARCHAR(16) username PRIMARY KEY
		VARCHAR(16) pwd NOT NULL
		INT age NOT NULL

