package http;

import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.QueryStringDecoder;
import io.netty.handler.codec.http.multipart.Attribute;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by linpeihui on 2017/8/25.
 */
public class RequestParamsParser
{
	private FullHttpRequest fullReq;

	public RequestParamsParser(FullHttpRequest req)
	{
		this.fullReq = req;
	}

	/**
	 * 解析请求参数
	 * @return 包含所有请求参数的键值对, 如果没有参数, 则返回空Map
	 *
	 * @throws IOException
	 */
	public Map<String, String> parse() throws IOException
	{
		HttpMethod method = fullReq.getMethod();
		Map<String, String> paramMap = new HashMap<>();
		if (HttpMethod.GET == method)
		{
			// GET
			QueryStringDecoder decoder = new QueryStringDecoder(fullReq.getUri());
			decoder.parameters().forEach((key, value) -> {
				// entry.getValue()是一个List, 只取第一个元素
				paramMap.put(key, value.get(0));
			});
		}
		else if (HttpMethod.POST == method)
		{
			// POST
			HttpPostRequestDecoder decoder = new HttpPostRequestDecoder(fullReq);
			decoder.offer(fullReq);
			List<InterfaceHttpData> paramList = decoder.getBodyHttpDatas();
			for (InterfaceHttpData parm : paramList)
			{
				Attribute data = (Attribute) parm;
				paramMap.put(data.getName(), data.getValue());
			}
		}
		return paramMap;
	}
}
