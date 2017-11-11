package com.example.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.example.entity.PictureMaster;
import com.example.repository.PictureMasterRepository;

public class JdbcPictureMDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	PictureMasterRepository pcRepository;


	public PictureMaster findById(String x_id){
		String sql = "SELECT * FROM chusui_user_master WHERE picture_id LIKE " + x_id + " ;";

		PictureMaster p_m = new PictureMaster();
		Map<String, Object> result = jdbcTemplate.queryForMap(sql);

		p_m.setPictureId((Long)result.get("picuture_id"));
		p_m.setPictureData((byte[])result.get("picuture_id"));
		p_m.setName((String)result.get("picuture_id"));

		return p_m;
	}

	public List<PictureMaster> findByName(String x_name){
		String sql = "SELECT * FROM chusui_user_master WHERE name LIKE '%" + x_name + "%'"
				+ "ORDER BY name ;";

		//検索結果を取得
		List<Map<String, Object>> rs_lis = null;
		rs_lis = jdbcTemplate.queryForList(sql);

			//検索結果をListで再取得
			List<PictureMaster> result = new ArrayList<PictureMaster>();

			for(Map<String, Object> pict : rs_lis) {
				PictureMaster tmp_mdl = new PictureMaster();
				tmp_mdl.setPictureId((Long)pict.get("picture_id"));
				tmp_mdl.setPictureData((byte[])pict.get("picture_id"));
				tmp_mdl.setName((String)pict.get("picture_id"));
			}

		return result;
	}

}
