package myshop.constants;

public enum Environment {
	DEFAULT("https://sajithatharaka.github.io/myshop_ecommerce/");

	String baseURL;

	Environment(String basURL) {
		this.baseURL = basURL;
	}

	public String getBaseURL() {
		return baseURL;
	}
}
