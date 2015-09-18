package model.obj;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import java.util.Date;
import javax.persistence.*;
//</editor-fold>

@Entity
@Table(name = "mc_movies")
@CCTypeConfig(label = "Movie", uniqueKey = "title", parameter = true)
public class Movie extends CCEntity {

    @Column(length = 64)
    @CCFieldConfig(componentId = "txtTitle", accessible = Accessible.MANDATORY, maxLength = 64)
    private String title;
    @Column(length = 255)
    @CCFieldConfig(componentId = "txtAlternateTitle", accessible = Accessible.MANDATORY, maxLength = Short.MAX_VALUE)
    private String alternateTitle;
    @Column(length = 255)
    @CCFieldConfig(componentId = "txtGenre", accessible = Accessible.MANDATORY, maxLength = Short.MAX_VALUE)
    private String genre;
    @Column(length = 255)
    @CCFieldConfig(componentId = "txtCountry", accessible = Accessible.MANDATORY, maxLength = Short.MAX_VALUE)
    private String country;
    @Temporal(value = TemporalType.DATE)
    @CCFieldConfig(componentId = "dtpReleaseDate", accessible = Accessible.MANDATORY, maxLength = 12)
    private Date releaseDate;
    @Column(length = 16)
    @CCFieldConfig(componentId = "txtRunningTime", accessible = Accessible.MANDATORY, maxLength = 16, visible = false)
    private String runningTime;
    @Column(length = 255)
    @CCFieldConfig(componentId = "txtStarring", accessible = Accessible.MANDATORY, maxLength = Short.MAX_VALUE, visible = false)
    private String starring;
    @Column(length = 32)
    @CCFieldConfig(componentId = "txtEpisodes", accessible = Accessible.MANDATORY, maxLength = 32)
    private String episodes;
    @Column(length = 255)
    @CCFieldConfig(componentId = "txtLink", accessible = Accessible.MANDATORY, maxLength = Short.MAX_VALUE, visible = false)
    private String link;
    @Column(length = Short.MAX_VALUE)
    @CCFieldConfig(componentId = "txtPlot", accessible = Accessible.MANDATORY, maxLength = Short.MAX_VALUE, visible = false)
    private String plot;
    @Column(length = Short.MAX_VALUE)
    @CCFieldConfig(componentId = "txtRemarks", maxLength = Short.MAX_VALUE, visible = false)
    private String remarks;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlternateTitle() {
        return alternateTitle;
    }

    public void setAlternateTitle(String alternateTitle) {
        this.alternateTitle = alternateTitle;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(String runningTime) {
        this.runningTime = runningTime;
    }

    public String getStarring() {
        return starring;
    }

    public void setStarring(String starring) {
        this.starring = starring;
    }

    public String getEpisodes() {
        return episodes;
    }

    public void setEpisodes(String episodes) {
        this.episodes = episodes;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
//</editor-fold>
}