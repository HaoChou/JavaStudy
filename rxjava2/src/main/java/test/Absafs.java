package test;

import com.alibaba.fastjson.JSON;
import jdk.nashorn.internal.parser.JSONParser;
import jdk.nashorn.internal.runtime.JSONFunctions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author zhou
 * Created on 2018/6/6
 */
public class Absafs {

    public  static String json = "[\n" +
            "    {\n" +
            "        \"deviceType\": \"iphone\",\n" +
            "        \"tokenId\": \"b865a1d0b8176c322bb091ffc22e8bf70540c13abf87fdae0cebbf8721898508%0A\",\n" +
            "        \"extraPara\": {\n" +
            "            \"period\": \"2018064\",\n" +
            "            \"gameEn\": \"ssq\",\n" +
            "            \"type\": \"2\"\n" +
            "        },\n" +
            "        \"pid\": null,\n" +
            "        \"title\": \"天天爱彩票双色球开奖\",\n" +
            "        \"message\": \"双色球第2018064期开奖号: 02,05,10,11,17,21 | 05\",\n" +
            "        \"deviceId\": \"F5BA8A80-6EBD-4DDB-81C0-1F6675BA5739\",\n" +
            "        \"overTimeDays\": \"1\",\n" +
            "        \"url\": \"ttacp8://awardDetail?gameEn=ssq\",\n" +
            "        \"pushType\": 100\n" +
            "    },\n" +
            "    {\n" +
            "        \"deviceType\": \"iphone\",\n" +
            "        \"tokenId\": \"0b1fe967629c0bb18e62d2a92ca025bc241911d686b2405f20d38e9a7e7252b1%0A\",\n" +
            "        \"extraPara\": {\n" +
            "            \"period\": \"2018064\",\n" +
            "            \"gameEn\": \"ssq\",\n" +
            "            \"type\": \"2\"\n" +
            "        },\n" +
            "        \"pid\": null,\n" +
            "        \"title\": \"天天爱彩票双色球开奖\",\n" +
            "        \"message\": \"双色球第2018064期开奖号: 02,05,10,11,17,21 | 05\",\n" +
            "        \"deviceId\": \"7D074E9F-6C17-4188-90BD-70DFC6241D46\",\n" +
            "        \"overTimeDays\": \"1\",\n" +
            "        \"url\": \"ttacp8://awardDetail?gameEn=ssq\",\n" +
            "        \"pushType\": 100\n" +
            "    },\n" +
            "    {\n" +
            "        \"deviceType\": \"iphone\",\n" +
            "        \"tokenId\": \"06aca4ab422f1b895e16fae39d9c2870132ce64dc46b89823c109565857c1c98%0A\",\n" +
            "        \"extraPara\": {\n" +
            "            \"period\": \"2018064\",\n" +
            "            \"gameEn\": \"ssq\",\n" +
            "            \"type\": \"2\"\n" +
            "        },\n" +
            "        \"pid\": null,\n" +
            "        \"title\": \"天天爱彩票双色球开奖\",\n" +
            "        \"message\": \"双色球第2018064期开奖号: 02,05,10,11,17,21 | 05\",\n" +
            "        \"deviceId\": \"8371F399-C168-410C-B43C-EBF0B80A1C45\",\n" +
            "        \"overTimeDays\": \"1\",\n" +
            "        \"url\": \"ttacp8://awardDetail?gameEn=ssq\",\n" +
            "        \"pushType\": 100\n" +
            "    },\n" +
            "    {\n" +
            "        \"deviceType\": \"iphone\",\n" +
            "        \"tokenId\": \"d54f04086add3f2cd94fb0031f48ceaf9bf9a9eb8d4889d8cfe60d950bc5d256%0A\",\n" +
            "        \"extraPara\": {\n" +
            "            \"period\": \"2018064\",\n" +
            "            \"gameEn\": \"ssq\",\n" +
            "            \"type\": \"2\"\n" +
            "        },\n" +
            "        \"pid\": null,\n" +
            "        \"title\": \"天天爱彩票双色球开奖\",\n" +
            "        \"message\": \"双色球第2018064期开奖号: 02,05,10,11,17,21 | 05\",\n" +
            "        \"deviceId\": \"926D2C8A-DE5C-48E2-9AEC-BABE292517C1\",\n" +
            "        \"overTimeDays\": \"1\",\n" +
            "        \"url\": \"ttacp8://awardDetail?gameEn=ssq\",\n" +
            "        \"pushType\": 100\n" +
            "    },\n" +
            "    {\n" +
            "        \"deviceType\": \"iphone\",\n" +
            "        \"tokenId\": \"15dd1a1000478853d0fb2781a2c53c605d406656ecfb1ec99f0a45a33b031afb%0A\",\n" +
            "        \"extraPara\": {\n" +
            "            \"period\": \"2018064\",\n" +
            "            \"gameEn\": \"ssq\",\n" +
            "            \"type\": \"2\"\n" +
            "        },\n" +
            "        \"pid\": null,\n" +
            "        \"title\": \"天天爱彩票双色球开奖\",\n" +
            "        \"message\": \"双色球第2018064期开奖号: 02,05,10,11,17,21 | 05\",\n" +
            "        \"deviceId\": \"101DCA6E-CF6D-4491-9EDA-D8BC2BAB8EED\",\n" +
            "        \"overTimeDays\": \"1\",\n" +
            "        \"url\": \"ttacp8://awardDetail?gameEn=ssq\",\n" +
            "        \"pushType\": 100\n" +
            "    },\n" +
            "    {\n" +
            "        \"deviceType\": \"iphone\",\n" +
            "        \"tokenId\": \"ff062901d8857e1047633d7d40b0e00517fe94e7f033b44e4e1e6807c54401c4%0A\",\n" +
            "        \"extraPara\": {\n" +
            "            \"period\": \"2018064\",\n" +
            "            \"gameEn\": \"ssq\",\n" +
            "            \"type\": \"2\"\n" +
            "        },\n" +
            "        \"pid\": null,\n" +
            "        \"title\": \"天天爱彩票双色球开奖\",\n" +
            "        \"message\": \"双色球第2018064期开奖号: 02,05,10,11,17,21 | 05\",\n" +
            "        \"deviceId\": \"80AFCD9A-EFF2-481D-9EB7-03CB50776D41\",\n" +
            "        \"overTimeDays\": \"1\",\n" +
            "        \"url\": \"ttacp8://awardDetail?gameEn=ssq\",\n" +
            "        \"pushType\": 100\n" +
            "    },\n" +
            "    {\n" +
            "        \"deviceType\": \"iphone\",\n" +
            "        \"tokenId\": \"9f1fb6d520a10888889deb3cb50f7df5e3772b43a01662b75f817426001dc62c%0A\",\n" +
            "        \"extraPara\": {\n" +
            "            \"period\": \"2018064\",\n" +
            "            \"gameEn\": \"ssq\",\n" +
            "            \"type\": \"2\"\n" +
            "        },\n" +
            "        \"pid\": null,\n" +
            "        \"title\": \"天天爱彩票双色球开奖\",\n" +
            "        \"message\": \"双色球第2018064期开奖号: 02,05,10,11,17,21 | 05\",\n" +
            "        \"deviceId\": \"FF0077FD-5330-403B-A403-682BCF204D15\",\n" +
            "        \"overTimeDays\": \"1\",\n" +
            "        \"url\": \"ttacp8://awardDetail?gameEn=ssq\",\n" +
            "        \"pushType\": 100\n" +
            "    },\n" +
            "    {\n" +
            "        \"deviceType\": \"iphone\",\n" +
            "        \"tokenId\": \"be632616c8e3d7936dc92471761c65998e90aad2f84d987a46e58ccccb1249af%0A\",\n" +
            "        \"extraPara\": {\n" +
            "            \"period\": \"2018064\",\n" +
            "            \"gameEn\": \"ssq\",\n" +
            "            \"type\": \"2\"\n" +
            "        },\n" +
            "        \"pid\": null,\n" +
            "        \"title\": \"天天爱彩票双色球开奖\",\n" +
            "        \"message\": \"双色球第2018064期开奖号: 02,05,10,11,17,21 | 05\",\n" +
            "        \"deviceId\": \"3D99DD91-4B27-49FF-90D2-1C7E169F423C\",\n" +
            "        \"overTimeDays\": \"1\",\n" +
            "        \"url\": \"ttacp8://awardDetail?gameEn=ssq\",\n" +
            "        \"pushType\": 100\n" +
            "    },\n" +
            "    {\n" +
            "        \"deviceType\": \"iphone\",\n" +
            "        \"tokenId\": \"6207756c23588c9a8b785d046e92329a93b0cf474eaad5d4168fc6a4bca0da8c%0A\",\n" +
            "        \"extraPara\": {\n" +
            "            \"period\": \"2018064\",\n" +
            "            \"gameEn\": \"ssq\",\n" +
            "            \"type\": \"2\"\n" +
            "        },\n" +
            "        \"pid\": null,\n" +
            "        \"title\": \"天天爱彩票双色球开奖\",\n" +
            "        \"message\": \"双色球第2018064期开奖号: 02,05,10,11,17,21 | 05\",\n" +
            "        \"deviceId\": \"601ADDC1-6DE3-44D7-AC3E-7C0D2381B4C5\",\n" +
            "        \"overTimeDays\": \"1\",\n" +
            "        \"url\": \"ttacp8://awardDetail?gameEn=ssq\",\n" +
            "        \"pushType\": 100\n" +
            "    },\n" +
            "    {\n" +
            "        \"deviceType\": \"iphone\",\n" +
            "        \"tokenId\": \"9fbb766278533b649a57aec4284376fcc34e31db6408453513bbcce438e5b46b%0A\",\n" +
            "        \"extraPara\": {\n" +
            "            \"period\": \"2018064\",\n" +
            "            \"gameEn\": \"ssq\",\n" +
            "            \"type\": \"2\"\n" +
            "        },\n" +
            "        \"pid\": null,\n" +
            "        \"title\": \"天天爱彩票双色球开奖\",\n" +
            "        \"message\": \"双色球第2018064期开奖号: 02,05,10,11,17,21 | 05\",\n" +
            "        \"deviceId\": \"08A2A00B-2E99-4691-8846-D243F9749264\",\n" +
            "        \"overTimeDays\": \"1\",\n" +
            "        \"url\": \"ttacp8://awardDetail?gameEn=ssq\",\n" +
            "        \"pushType\": 100\n" +
            "    },\n" +
            "    {\n" +
            "        \"deviceType\": \"iphone\",\n" +
            "        \"tokenId\": \"8616f372639baa29d534c6040cc34eab035c635d26db8611484a4ce07704670c%0A\",\n" +
            "        \"extraPara\": {\n" +
            "            \"period\": \"2018064\",\n" +
            "            \"gameEn\": \"ssq\",\n" +
            "            \"type\": \"2\"\n" +
            "        },\n" +
            "        \"pid\": null,\n" +
            "        \"title\": \"天天爱彩票双色球开奖\",\n" +
            "        \"message\": \"双色球第2018064期开奖号: 02,05,10,11,17,21 | 05\",\n" +
            "        \"deviceId\": \"8DAD8621-AD7A-4072-A648-CC738AFC8C5E\",\n" +
            "        \"overTimeDays\": \"1\",\n" +
            "        \"url\": \"ttacp8://awardDetail?gameEn=ssq\",\n" +
            "        \"pushType\": 100\n" +
            "    },\n" +
            "    {\n" +
            "        \"deviceType\": \"iphone\",\n" +
            "        \"tokenId\": \"807c74bf155c0821440de7d1cd293396a44bc24aeb7bfd1d7e158447c0e6b19d%0A\",\n" +
            "        \"extraPara\": {\n" +
            "            \"period\": \"2018064\",\n" +
            "            \"gameEn\": \"ssq\",\n" +
            "            \"type\": \"2\"\n" +
            "        },\n" +
            "        \"pid\": null,\n" +
            "        \"title\": \"天天爱彩票双色球开奖\",\n" +
            "        \"message\": \"双色球第2018064期开奖号: 02,05,10,11,17,21 | 05\",\n" +
            "        \"deviceId\": \"AF4A3CD7-70C6-4EB5-8E8A-5EC33A5EAEFE\",\n" +
            "        \"overTimeDays\": \"1\",\n" +
            "        \"url\": \"ttacp8://awardDetail?gameEn=ssq\",\n" +
            "        \"pushType\": 100\n" +
            "    },\n" +
            "    {\n" +
            "        \"deviceType\": \"iphone\",\n" +
            "        \"tokenId\": \"4762cfe9d42162096a848fe68b8b418c69a0afa60e9ad9c897a5069ac20c20de%0A\",\n" +
            "        \"extraPara\": {\n" +
            "            \"period\": \"2018064\",\n" +
            "            \"gameEn\": \"ssq\",\n" +
            "            \"type\": \"2\"\n" +
            "        },\n" +
            "        \"pid\": null,\n" +
            "        \"title\": \"天天爱彩票双色球开奖\",\n" +
            "        \"message\": \"双色球第2018064期开奖号: 02,05,10,11,17,21 | 05\",\n" +
            "        \"deviceId\": \"55BF73F4-034D-4DCB-93E0-4441DE77F069\",\n" +
            "        \"overTimeDays\": \"1\",\n" +
            "        \"url\": \"ttacp8://awardDetail?gameEn=ssq\",\n" +
            "        \"pushType\": 100\n" +
            "    },\n" +
            "    {\n" +
            "        \"deviceType\": \"iphone\",\n" +
            "        \"tokenId\": \"105b716b318325f78522fb0183f99ac5f54e7ca9718c76b5ac3e8883d57dd1e6%0A\",\n" +
            "        \"extraPara\": {\n" +
            "            \"period\": \"2018064\",\n" +
            "            \"gameEn\": \"ssq\",\n" +
            "            \"type\": \"2\"\n" +
            "        },\n" +
            "        \"pid\": null,\n" +
            "        \"title\": \"天天爱彩票双色球开奖\",\n" +
            "        \"message\": \"双色球第2018064期开奖号: 02,05,10,11,17,21 | 05\",\n" +
            "        \"deviceId\": \"8E2B711C-BBC1-4625-B679-100B87C5497B\",\n" +
            "        \"overTimeDays\": \"1\",\n" +
            "        \"url\": \"ttacp8://awardDetail?gameEn=ssq\",\n" +
            "        \"pushType\": 100\n" +
            "    },\n" +
            "    {\n" +
            "        \"deviceType\": \"iphone\",\n" +
            "        \"tokenId\": \"e6a8649b7a045f46ef610e4395226ea9022b03abc8b49c64828834ae37c3125e%0A\",\n" +
            "        \"extraPara\": {\n" +
            "            \"period\": \"2018064\",\n" +
            "            \"gameEn\": \"ssq\",\n" +
            "            \"type\": \"2\"\n" +
            "        },\n" +
            "        \"pid\": null,\n" +
            "        \"title\": \"天天爱彩票双色球开奖\",\n" +
            "        \"message\": \"双色球第2018064期开奖号: 02,05,10,11,17,21 | 05\",\n" +
            "        \"deviceId\": \"36795B51-C7ED-43A7-93B9-A6F0F5ADE6E4\",\n" +
            "        \"overTimeDays\": \"1\",\n" +
            "        \"url\": \"ttacp8://awardDetail?gameEn=ssq\",\n" +
            "        \"pushType\": 100\n" +
            "    },\n" +
            "    {\n" +
            "        \"deviceType\": \"iphone\",\n" +
            "        \"tokenId\": \"fb96e4f0799efdb8a0292753c573188a91bf13ce4d2d63c3145efcd4e07baa06%0A\",\n" +
            "        \"extraPara\": {\n" +
            "            \"period\": \"2018064\",\n" +
            "            \"gameEn\": \"ssq\",\n" +
            "            \"type\": \"2\"\n" +
            "        },\n" +
            "        \"pid\": null,\n" +
            "        \"title\": \"天天爱彩票双色球开奖\",\n" +
            "        \"message\": \"双色球第2018064期开奖号: 02,05,10,11,17,21 | 05\",\n" +
            "        \"deviceId\": \"742F8FEC-3074-466F-AB29-9C06DCECCD1C\",\n" +
            "        \"overTimeDays\": \"1\",\n" +
            "        \"url\": \"ttacp8://awardDetail?gameEn=ssq\",\n" +
            "        \"pushType\": 100\n" +
            "    },\n" +
            "    {\n" +
            "        \"deviceType\": \"iphone\",\n" +
            "        \"tokenId\": \"bec85009f1a339b356cbc6128f6c195fea8a60e2ab0ee5492bc98c4ce1bdb087%0A\",\n" +
            "        \"extraPara\": {\n" +
            "            \"period\": \"2018064\",\n" +
            "            \"gameEn\": \"ssq\",\n" +
            "            \"type\": \"2\"\n" +
            "        },\n" +
            "        \"pid\": null,\n" +
            "        \"title\": \"天天爱彩票双色球开奖\",\n" +
            "        \"message\": \"双色球第2018064期开奖号: 02,05,10,11,17,21 | 05\",\n" +
            "        \"deviceId\": \"468D70CB-8C00-408A-9640-0230B2765472\",\n" +
            "        \"overTimeDays\": \"1\",\n" +
            "        \"url\": \"ttacp8://awardDetail?gameEn=ssq\",\n" +
            "        \"pushType\": 100\n" +
            "    },\n" +
            "    {\n" +
            "        \"deviceType\": \"iphone\",\n" +
            "        \"tokenId\": \"cdffb55a3a48592198fd3810d116e9c56df189d233041fa672a159f8b0d6859d%0A\",\n" +
            "        \"extraPara\": {\n" +
            "            \"period\": \"2018064\",\n" +
            "            \"gameEn\": \"ssq\",\n" +
            "            \"type\": \"2\"\n" +
            "        },\n" +
            "        \"pid\": null,\n" +
            "        \"title\": \"天天爱彩票双色球开奖\",\n" +
            "        \"message\": \"双色球第2018064期开奖号: 02,05,10,11,17,21 | 05\",\n" +
            "        \"deviceId\": \"3E00A05D-9461-4906-BEC0-9BEA5FAA2A91\",\n" +
            "        \"overTimeDays\": \"1\",\n" +
            "        \"url\": \"ttacp8://awardDetail?gameEn=ssq\",\n" +
            "        \"pushType\": 100\n" +
            "    },\n" +
            "    {\n" +
            "        \"deviceType\": \"iphone\",\n" +
            "        \"tokenId\": \"f63490f94ea9e251294b10317c550444c2e1c0e906a5a6c4d4dec019e76d3877%0A\",\n" +
            "        \"extraPara\": {\n" +
            "            \"period\": \"2018064\",\n" +
            "            \"gameEn\": \"ssq\",\n" +
            "            \"type\": \"2\"\n" +
            "        },\n" +
            "        \"pid\": null,\n" +
            "        \"title\": \"天天爱彩票双色球开奖\",\n" +
            "        \"message\": \"双色球第2018064期开奖号: 02,05,10,11,17,21 | 05\",\n" +
            "        \"deviceId\": \"3B9434A8-9D33-4E8E-8DC4-51C77E8ED77D\",\n" +
            "        \"overTimeDays\": \"1\",\n" +
            "        \"url\": \"ttacp8://awardDetail?gameEn=ssq\",\n" +
            "        \"pushType\": 100\n" +
            "    },\n" +
            "    {\n" +
            "        \"deviceType\": \"iphone\",\n" +
            "        \"tokenId\": \"f5d5d341cc23cb109252698d87d8a521c2a39666b65d8e44905145bce6c4627f%0A\",\n" +
            "        \"extraPara\": {\n" +
            "            \"period\": \"2018064\",\n" +
            "            \"gameEn\": \"ssq\",\n" +
            "            \"type\": \"2\"\n" +
            "        },\n" +
            "        \"pid\": null,\n" +
            "        \"title\": \"天天爱彩票双色球开奖\",\n" +
            "        \"message\": \"双色球第2018064期开奖号: 02,05,10,11,17,21 | 05\",\n" +
            "        \"deviceId\": \"97969DAA-4143-4659-B7A6-6F012F0027C8\",\n" +
            "        \"overTimeDays\": \"1\",\n" +
            "        \"url\": \"ttacp8://awardDetail?gameEn=ssq\",\n" +
            "        \"pushType\": 100\n" +
            "    },\n" +
            "    {\n" +
            "        \"deviceType\": \"iphone\",\n" +
            "        \"tokenId\": \"4a0c7862632b77485221d12bbd9a4f33bd6cd2bee62ccb35f043ddf1cc52109a%0A\",\n" +
            "        \"extraPara\": {\n" +
            "            \"period\": \"2018064\",\n" +
            "            \"gameEn\": \"ssq\",\n" +
            "            \"type\": \"2\"\n" +
            "        },\n" +
            "        \"pid\": null,\n" +
            "        \"title\": \"天天爱彩票双色球开奖\",\n" +
            "        \"message\": \"双色球第2018064期开奖号: 02,05,10,11,17,21 | 05\",\n" +
            "        \"deviceId\": \"0EFC8C3A-9434-409D-A80F-9CD37CCA3C6D\",\n" +
            "        \"overTimeDays\": \"1\",\n" +
            "        \"url\": \"ttacp8://awardDetail?gameEn=ssq\",\n" +
            "        \"pushType\": 100\n" +
            "    },\n" +
            "    {\n" +
            "        \"deviceType\": \"iphone\",\n" +
            "        \"tokenId\": \"d40567504afe202999db11eb382b02f6932020b4f08f0020ac0838d93f46a8fe%0A\",\n" +
            "        \"extraPara\": {\n" +
            "            \"period\": \"2018064\",\n" +
            "            \"gameEn\": \"ssq\",\n" +
            "            \"type\": \"2\"\n" +
            "        },\n" +
            "        \"pid\": null,\n" +
            "        \"title\": \"天天爱彩票双色球开奖\",\n" +
            "        \"message\": \"双色球第2018064期开奖号: 02,05,10,11,17,21 | 05\",\n" +
            "        \"deviceId\": \"3478DCD1-7BAE-4567-AEDA-EC8F4660D584\",\n" +
            "        \"overTimeDays\": \"1\",\n" +
            "        \"url\": \"ttacp8://awardDetail?gameEn=ssq\",\n" +
            "        \"pushType\": 100\n" +
            "    },\n" +
            "    {\n" +
            "        \"deviceType\": \"iphone\",\n" +
            "        \"tokenId\": \"519c8e033acd9457da446024024b03c1be0d9e3f9fce983062c059bffe63977c%0A\",\n" +
            "        \"extraPara\": {\n" +
            "            \"period\": \"2018064\",\n" +
            "            \"gameEn\": \"ssq\",\n" +
            "            \"type\": \"2\"\n" +
            "        },\n" +
            "        \"pid\": null,\n" +
            "        \"title\": \"天天爱彩票双色球开奖\",\n" +
            "        \"message\": \"双色球第2018064期开奖号: 02,05,10,11,17,21 | 05\",\n" +
            "        \"deviceId\": \"12D7A54F-F57D-4CD1-A358-9C128C651B7E\",\n" +
            "        \"overTimeDays\": \"1\",\n" +
            "        \"url\": \"ttacp8://awardDetail?gameEn=ssq\",\n" +
            "        \"pushType\": 100\n" +
            "    },\n" +
            "    {\n" +
            "        \"deviceType\": \"iphone\",\n" +
            "        \"tokenId\": \"4f0e7ba9fe07316398d35268b03eb0195e15831237592ba480d9e60fc3dec7ee\",\n" +
            "        \"extraPara\": {\n" +
            "            \"period\": \"2018064\",\n" +
            "            \"gameEn\": \"ssq\",\n" +
            "            \"type\": \"2\"\n" +
            "        },\n" +
            "        \"pid\": null,\n" +
            "        \"title\": \"天天爱彩票双色球开奖\",\n" +
            "        \"message\": \"双色球第2018064期开奖号: 02,05,10,11,17,21 | 05\",\n" +
            "        \"deviceId\": \"B4D1207D-C58A-47E6-A285-937C685C37BD\",\n" +
            "        \"overTimeDays\": \"1\",\n" +
            "        \"url\": \"ttacp8://awardDetail?gameEn=ssq\",\n" +
            "        \"pushType\": 100\n" +
            "    },\n" +
            "    {\n" +
            "        \"deviceType\": \"iphone\",\n" +
            "        \"tokenId\": \"35e2dea2982e2b35033862775d818d14598307b37966604502ea780465090bc5\",\n" +
            "        \"extraPara\": {\n" +
            "            \"period\": \"2018064\",\n" +
            "            \"gameEn\": \"ssq\",\n" +
            "            \"type\": \"2\"\n" +
            "        },\n" +
            "        \"pid\": null,\n" +
            "        \"title\": \"天天爱彩票双色球开奖\",\n" +
            "        \"message\": \"双色球第2018064期开奖号: 02,05,10,11,17,21 | 05\",\n" +
            "        \"deviceId\": \"F2A0FCF7-CB32-4FA7-BD5D-98848A571932\",\n" +
            "        \"overTimeDays\": \"1\",\n" +
            "        \"url\": \"ttacp8://awardDetail?gameEn=ssq\",\n" +
            "        \"pushType\": 100\n" +
            "    }\n" +
            "]";
    public static void main(String[] args) {

        List<String> a = new ArrayList<>();
        a.add("123");
        a.add("121");
        a.add("4");
        a.add("97");
        Collections.sort(a);
        System.out.println(a);

//        Object  o = JSON.parse(json,new HashMap<>());


//        System.out.println(o);
    }
}
