package control;

/**
 * @description This class contains the attributes of WebPage objects and the
 *              basic predefined methods
 * @author Marcelino Gil Nombela
 * @version 1.0
 * @since 09/05/2023
 */
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

	@Override
	public String toString() {
		return "WebPage [webId=" + webId + ", webName=" + webName + ", url=" + url + ", budget=" + budget + "]";
	}

}
