package com.tsugaruweb.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.tsugaruweb.entity.Author;
import com.tsugaruweb.entity.PictureMaster;
import com.tsugaruweb.repository.PictureMasterRepository;

@Component
public class JdbcPictureMDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	PictureMasterRepository pcRepository;


	/**
	 * Idで検索
	 * @param x_Id
	 * @return
	 */
	public PictureMaster findById(Long x_Id){
		String sql = "SELECT * FROM PictureMaster WHERE picture_id = " + x_Id+ " ;";

		PictureMaster p_m = new PictureMaster();
		Map<String, Object> result = jdbcTemplate.queryForMap(sql);

		p_m.setPictureId((Long)result.get("picture_id"));
		p_m.setPictureData((byte[])result.get("picture_data"));
		p_m.setName((String)result.get("name"));

		return p_m;
	}

	/**
	 * 名前で検索(あいまい)
	 * @param x_Id
	 * @return
	 */
	public List<PictureMaster> findByName(Long x_Name){
		String sql = "SELECT * FROM PictureMaster WHERE name LIKE '%" + x_Name+ "%' ;";

		List<PictureMaster> pm_lis = new ArrayList<PictureMaster>();
		List<Map<String, Object>>  result = jdbcTemplate.queryForList(sql);

		for(Map<String, Object> iterator  : result) {

			//取得したデータをピクチャーマスターに
			PictureMaster pm = new PictureMaster();
			pm.setPictureId((Long)iterator.get("picture_id"));
			pm.setPictureData((byte[])iterator.get("picture_data"));
			pm.setName((String)iterator.get("name"));

			//結果に加える
			pm_lis.add(pm);
		}

		return pm_lis;
	}

}
