package org.fran.demo.flowable.springboot.controller;

import org.fran.demo.flowable.springboot.vo.JsonResult;
import org.fran.demo.flowable.springboot.vo.RemoveConfigParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/test")
public class TestRestController {
	static Logger log = LoggerFactory.getLogger(TestRestController.class);

	@PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public JsonResult<String> postTest(
			@RequestBody Map<String, Object> vo
	){
		JsonResult<String> res = new JsonResult<>();
		res.setData("dsadsad");
		res.setDescription("sahdjhsajdhjsahdjsajdjh");
		res.setStatus(200);
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
	public JsonResult getTest(@RequestParam String id){

		JsonResult res = new JsonResult<>();

		res.setDescription("sahdjhsajdhjsahdjsajdjh");
		res.setStatus(200);
		return res;
	}


	//使用SQL_CALC_FOUND_ROWS + found_rows() 在一条命令中获取count总数，可用于翻页。
	//注意：mysql连接需要加上allowMultiQueries=true 开启多条sql执行，不然会报错
	@GetMapping(value = "/pagerByUserName", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
	public JsonResult pagerByUserName(@RequestParam(required = false) String name){


		JsonResult res = new JsonResult<>();

		res.setStatus(200);
		return res;
	}

	//后端图片上传
	@PostMapping(value = "/upload",
			consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public JsonResult upload(
			@RequestPart("uploadFile")MultipartFile uploadFile,
			@RequestPart("description")String description,
			@RequestPart("name")String name){
		FileOutputStream o = null;
		InputStream inputStream = null;
		try {
			inputStream = uploadFile.getInputStream();
			File f = new File("C:\\temp\\" + name);
			o = new FileOutputStream(f);
			byte[] b = new byte[1024];
			int i = 0;
			while((i = inputStream.read(b))!= -1){
				o.write(b, 0, i);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(o!= null)
					o.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(inputStream!= null)
					inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		JsonResult res = new JsonResult();
		res.setData(name);
		res.setDescription("success");
		res.setStatus(200);
		return res;
	}

	//后端图片预览
	@RequestMapping(value="/download", method = RequestMethod.GET)
	public void download(
			HttpServletResponse httpResponse,
			@RequestParam(name="fileName") String fileName
	){
		File sourceFile = new File("C:\\temp\\" + fileName);
		httpResponse.setContentLengthLong(sourceFile.length());
		httpResponse.setContentType("image/jpg");
		httpResponse.setStatus(HttpServletResponse.SC_OK);

		httpResponse.setHeader("Content-disposition","attachment;filename=" + sourceFile.getName());

		try(FileInputStream in = new FileInputStream(sourceFile);
			ServletOutputStream out = httpResponse.getOutputStream();
		){
			byte[] b = new byte[1024];
			while(in.read(b)!= -1){
				out.write(b);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	@CrossOrigin("http://127.0.0.1:8080")
	@GetMapping(value = "/checkLogin", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
	public JsonResult<String> checkLogin(){

	    //从session中获取全局用户信息 scope 1为session
		Object user = RequestContextHolder.getRequestAttributes().getAttribute("user", 1);

		JsonResult<String> res = new JsonResult<>();
		res.setDescription("sahdjhsajdhjsahdjsajdjh");
		res.setStatus(200);
		return res;
	}


	@PostMapping(value = "/selectString", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public JsonResult<String> firstTest(@RequestBody RemoveConfigParam baseParam){
		log.info("firstTest");
		JsonResult<String> res = new JsonResult<>();
		res.setData("dsadsad");
		res.setDescription("sahdjhsajdhjsahdjsajdjh");
		res.setStatus(200);
		return res;
	}

	@GetMapping(value = "/selectList", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
	public JsonResult<List<String>> selectTest(@RequestParam(name="id") int ids){
		log.info("selectAll ids:["+ ids +"]");
		if(ids == 5)
			throw new RuntimeException("error!!!!");

		JsonResult<List<String>> res = new JsonResult<>();
		res.setData(new ArrayList<String>(){
			{
				add("sadsda1");
				add("sadsda2");
				add("sadsda3");
				add("sadsda4");
				add("sadsda5");
			}
		});
		res.setDescription("sahdjhsajdhjsahdjsajdjh");
		res.setStatus(200);
		return res;
	}


}