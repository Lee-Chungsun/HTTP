public String forceCall(HttpServletRequest request, HttpServletResponse response) throws Exception {
  // request로 받고 reponse로 응답해준다.
  JSONParser jsonParser = new JSONParser();
  JSONObject jsonObject = (JSONObject) jsonParser.parse(requstBody(request));
  //json을 읽기 위한? 파싱
  //requstBody 함수는 아래쪽에 있는 함수
  jsonObject.get("key").toString();
  // 이렇게 get("key")값으로 가져올수 있게된다.

  PrintWriter resWriter = response.getWriter();
  // 응답해줄 메세지적을
  response.setContentType("text/xml;charset=utf-8");
  resWriter.print(xml);
  // xml로 전송이된다
  
      -  
      -  
      -  
      -  
 아래 필요 로직 

