package site.itwill05.di;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionBean {
	private List<String> nameList;
	private Set<String> nameSet;
	//제네릭의 자료형을 인터페이스로 설정할 경우 자식 인스턴스를 콜렉션 요소로 저장 가능
	private List<Controller> controllerList;
	private Set<Controller> controllerSet;
	private Map<String, Controller> controllerMap;
	private Properties properties;
	
	public CollectionBean() {
		System.out.println("### CollectionBean 클래스의 기본 생성자 호출 ###");
	}

	public List<String> getNameList() {
		return nameList;
	}

	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}

	public Set<String> getNameSet() {
		return nameSet;
	}

	public void setNameSet(Set<String> nameSet) {
		this.nameSet = nameSet;
	}

	public List<Controller> getControllerList() {
		return controllerList;
	}

	public void setControllerList(List<Controller> controllerList) {
		this.controllerList = controllerList;
	}

	public Set<Controller> getControllerSet() {
		return controllerSet;
	}

	public void setControllerSet(Set<Controller> controllerSet) {
		this.controllerSet = controllerSet;
	}

	public Map<String, Controller> getControllerMap() {
		return controllerMap;
	}

	public void setControllerMap(Map<String, Controller> controllerMap) {
		this.controllerMap = controllerMap;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
}
