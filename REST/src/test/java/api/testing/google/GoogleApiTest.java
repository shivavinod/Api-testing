
package api.testing.google;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GoogleApiTest {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("totalItems")
    @Expose
    private Integer totalItems;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

	@Override
	public String toString() {
		return "GoogleApiTest [kind=" + kind + ", totalItems=" + totalItems + ", items=" + items + "]";
	}

}
