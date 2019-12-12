package ddit.or.kr.ibatis.config;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapClientFactory {
	
	static SqlMapClient smc;
	static {
		Reader rd;
		try {
			//1. iBatis의 환경설정파일을 읽어와 실행시킨다.
			//1-1. 문자 인코딩 캐릭터셋을 설정한다.
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			
			//1-2. xml파일 읽어오기
			rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			
			//1-3. 위에서 읽어온 Reader객체를 이용하여 실제 작업을 진행할 객체를 생성한다.
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlMapClient getSqlMapClient() {
		return smc;
	}
}
