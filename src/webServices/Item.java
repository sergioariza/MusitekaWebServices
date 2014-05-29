package webServices;

public class Item {
    private int idItem;
    private String descItem;
    private String linkUrlImagen;

    public Item() {

    }

    public Item(int idItem, String descItem, String linkUrlImagen) {
	super();
	this.idItem = idItem;
	this.descItem = descItem;
	this.linkUrlImagen = linkUrlImagen;
    }

    public int getIdItem() {
	return idItem;
    }

    public void setIdItem(int idItem) {
	this.idItem = idItem;
    }

    public String getDescItem() {
	return descItem;
    }

    public void setDescItem(String descItem) {
	this.descItem = descItem;
    }

    public String getLinkUrlImagen() {
	return linkUrlImagen;
    }

    public void setLinkUrlImagen(String linkUrlImagen) {
	this.linkUrlImagen = linkUrlImagen;
    }
}