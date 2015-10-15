package zx.soft.words.model;

public class Words {
	
	private int id;
	private int cate_id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCate_id() {
		return cate_id;
	}
	public void setCate_id(int cate_id) {
		this.cate_id = cate_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Words [id=" + id + ", cate_id=" + cate_id + ", name=" + name + "]";
	}
	
	

}
