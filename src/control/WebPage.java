package control;

public class WebPage {

	private int webId;
	private String webName;
	private String url;
	private int budget;
	public WebPage(int webId, String webName, String url, int budget) {
		super();
		this.webId = webId;
		this.webName = webName;
		this.url = url;
		this.budget = budget;
	}
	public WebPage(String webName, String url, int budget) {
		super();
		this.webName = webName;
		this.url = url;
		this.budget = budget;
	}
	public int getWebId() {
		return webId;
	}
	public void setWebId(int webId) {
		this.webId = webId;
	}
	public String getWebName() {
		return webName;
	}
	public void setWebName(String webName) {
		this.webName = webName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	
	
	
}
	