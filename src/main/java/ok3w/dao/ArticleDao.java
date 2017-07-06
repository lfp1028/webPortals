package ok3w.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import ok3w.entity.Article;
@Repository
public class ArticleDao extends BaseDao<Article> {
	
	public Article getMoveArticle()
	{
		String sql="from Article where isMove=true and isPass=true";
		List list = getSession().createQuery(sql).list();
		Article a=(Article) list.get(0);
		return a;
		
	}
	public List<Article> getPicList()
	{
		String sql="from Article where isPlay=true and isPass=true";
		List list = getSession().createQuery(sql).list();
		return list;
		
	}
	/**
	 * 
	 * @param id classid,count number limit
	 * @return ������д˷����£������ӷ��ࣩ�������б�
	 */
	public List<Article> getClassArticles(int id,int count)
	{
		String sql="SELECT * from ok3w_article WHERE FIND_IN_SET(:id,SortPath)"
				+ " and isPass=true ORDER BY isTop DESC,isCommend DESC,addTime DESC";
		List<Article> list = getSession().createSQLQuery(sql).addEntity(Article.class)
				.setMaxResults(count).setInteger("id", id).list();
		return list;
		
	}
	public List<Article> getClassArticles(int id)
	{
		String sql="SELECT * from ok3w_article WHERE FIND_IN_SET(:id,SortPath)"
				+ "and isPass=true ORDER BY isTop DESC,isCommend DESC,addTime DESC";
		List<Article> list = getSession().createSQLQuery(sql).addEntity(Article.class)
				.setInteger("id", id).list();
		return list;
		
	}
	public List<Article> getClassArticlesOrderByHits(int id,int count)
	{
		String sql="SELECT * from ok3w_article WHERE FIND_IN_SET(:id,SortPath)"
				+ " and isPass=true ORDER BY Hits DESC";
		List<Article> list = getSession().createSQLQuery(sql).addEntity(Article.class)
				.setMaxResults(count).setInteger("id", id).list();
		return list;
	}
	public List<Article> getClassArticlesOrderAddTime(int id,int count)
	{
		String sql="SELECT * from ok3w_article WHERE FIND_IN_SET(:id,SortPath)"
				+ " and isPass=true ORDER BY addTime DESC";
		List<Article> list = getSession().createSQLQuery(sql).addEntity(Article.class)
				.setMaxResults(count).setInteger("id", id).list();
		return list;
	}
	public List<Article> listDesc()
	{
		String sql="from Article ORDER BY isTop DESC,isCommend DESC,addTime DESC";
		List list = getSession().createQuery(sql).list();
		return list;
		
	}
	/**
	 * ��ҳ��ʾ
	 * @param page ҳ��
	 * @param count ÿҳ��¼��
	 * @return
	 */
	public List<Article> listPage(int page,int count)
	{
		String sql="from Article ORDER BY id";
		List list = getSession().createQuery(sql)
				.setFirstResult((page-1)*count)
				.setMaxResults(count)
				.list();
		return list;
		
	}
}
