package kr.co.saramin.lab.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "hexaco_result_db", schema = "workshop", catalog = "")
public class HexacoResultDbEntity {
    private int key;
    private int userKey;
    private String name;
    private int honestyHumility;
    private int emotionality;
    private int extraversion;
    private int agreeableness;
    private int conscientiousness;
    private int opennessToExperience;
    private int altruism;
    private int sincerity;
    private int fairness;
    private int greedAvoidance;
    private int modesty;
    private int fearfulness;
    private int anxiety;
    private int dependence;
    private int sentimentality;
    private int socialSelfEsteem;
    private int socialBoldness;
    private int sociability;
    private int liveliness;
    private int forgiveness;
    private int gentleness;
    private int flexibility;
    private int patience;
    private int organization;
    private int diligence;
    private int perfectionism;
    private int prudence;
    private int aestheticAppreciation;
    private int inquisitiveness;
    private int creativity;
    private int unconventionality;

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(name = "key")
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Basic
    @Column(name = "user_key")
    public int getUserKey() {
        return userKey;
    }

    public void setUserKey(int userKey) {
        this.userKey = userKey;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "honesty_humility")
    public int getHonestyHumility() {
        return honestyHumility;
    }

    public void setHonestyHumility(int honestyHumility) {
        this.honestyHumility = honestyHumility;
    }

    @Basic
    @Column(name = "emotionality")
    public int getEmotionality() {
        return emotionality;
    }

    public void setEmotionality(int emotionality) {
        this.emotionality = emotionality;
    }

    @Basic
    @Column(name = "extraversion")
    public int getExtraversion() {
        return extraversion;
    }

    public void setExtraversion(int extraversion) {
        this.extraversion = extraversion;
    }

    @Basic
    @Column(name = "agreeableness")
    public int getAgreeableness() {
        return agreeableness;
    }

    public void setAgreeableness(int agreeableness) {
        this.agreeableness = agreeableness;
    }

    @Basic
    @Column(name = "conscientiousness")
    public int getConscientiousness() {
        return conscientiousness;
    }

    public void setConscientiousness(int conscientiousness) {
        this.conscientiousness = conscientiousness;
    }

    @Basic
    @Column(name = "openness_to_experience")
    public int getOpennessToExperience() {
        return opennessToExperience;
    }

    public void setOpennessToExperience(int opennessToExperience) {
        this.opennessToExperience = opennessToExperience;
    }

    @Basic
    @Column(name = "altruism")
    public int getAltruism() {
        return altruism;
    }

    public void setAltruism(int altruism) {
        this.altruism = altruism;
    }

    @Basic
    @Column(name = "sincerity")
    public int getSincerity() {
        return sincerity;
    }

    public void setSincerity(int sincerity) {
        this.sincerity = sincerity;
    }

    @Basic
    @Column(name = "fairness")
    public int getFairness() {
        return fairness;
    }

    public void setFairness(int fairness) {
        this.fairness = fairness;
    }

    @Basic
    @Column(name = "greed_avoidance")
    public int getGreedAvoidance() {
        return greedAvoidance;
    }

    public void setGreedAvoidance(int greedAvoidance) {
        this.greedAvoidance = greedAvoidance;
    }

    @Basic
    @Column(name = "modesty")
    public int getModesty() {
        return modesty;
    }

    public void setModesty(int modesty) {
        this.modesty = modesty;
    }

    @Basic
    @Column(name = "fearfulness")
    public int getFearfulness() {
        return fearfulness;
    }

    public void setFearfulness(int fearfulness) {
        this.fearfulness = fearfulness;
    }

    @Basic
    @Column(name = "anxiety")
    public int getAnxiety() {
        return anxiety;
    }

    public void setAnxiety(int anxiety) {
        this.anxiety = anxiety;
    }

    @Basic
    @Column(name = "dependence")
    public int getDependence() {
        return dependence;
    }

    public void setDependence(int dependence) {
        this.dependence = dependence;
    }

    @Basic
    @Column(name = "sentimentality")
    public int getSentimentality() {
        return sentimentality;
    }

    public void setSentimentality(int sentimentality) {
        this.sentimentality = sentimentality;
    }

    @Basic
    @Column(name = "social_self_esteem")
    public int getSocialSelfEsteem() {
        return socialSelfEsteem;
    }

    public void setSocialSelfEsteem(int socialSelfEsteem) {
        this.socialSelfEsteem = socialSelfEsteem;
    }

    @Basic
    @Column(name = "social_boldness")
    public int getSocialBoldness() {
        return socialBoldness;
    }

    public void setSocialBoldness(int socialBoldness) {
        this.socialBoldness = socialBoldness;
    }

    @Basic
    @Column(name = "sociability")
    public int getSociability() {
        return sociability;
    }

    public void setSociability(int sociability) {
        this.sociability = sociability;
    }

    @Basic
    @Column(name = "liveliness")
    public int getLiveliness() {
        return liveliness;
    }

    public void setLiveliness(int liveliness) {
        this.liveliness = liveliness;
    }

    @Basic
    @Column(name = "forgiveness")
    public int getForgiveness() {
        return forgiveness;
    }

    public void setForgiveness(int forgiveness) {
        this.forgiveness = forgiveness;
    }

    @Basic
    @Column(name = "gentleness")
    public int getGentleness() {
        return gentleness;
    }

    public void setGentleness(int gentleness) {
        this.gentleness = gentleness;
    }

    @Basic
    @Column(name = "flexibility")
    public int getFlexibility() {
        return flexibility;
    }

    public void setFlexibility(int flexibility) {
        this.flexibility = flexibility;
    }

    @Basic
    @Column(name = "patience")
    public int getPatience() {
        return patience;
    }

    public void setPatience(int patience) {
        this.patience = patience;
    }

    @Basic
    @Column(name = "organization")
    public int getOrganization() {
        return organization;
    }

    public void setOrganization(int organization) {
        this.organization = organization;
    }

    @Basic
    @Column(name = "diligence")
    public int getDiligence() {
        return diligence;
    }

    public void setDiligence(int diligence) {
        this.diligence = diligence;
    }

    @Basic
    @Column(name = "perfectionism")
    public int getPerfectionism() {
        return perfectionism;
    }

    public void setPerfectionism(int perfectionism) {
        this.perfectionism = perfectionism;
    }

    @Basic
    @Column(name = "prudence")
    public int getPrudence() {
        return prudence;
    }

    public void setPrudence(int prudence) {
        this.prudence = prudence;
    }

    @Basic
    @Column(name = "aesthetic_appreciation")
    public int getAestheticAppreciation() {
        return aestheticAppreciation;
    }

    public void setAestheticAppreciation(int aestheticAppreciation) {
        this.aestheticAppreciation = aestheticAppreciation;
    }

    @Basic
    @Column(name = "inquisitiveness")
    public int getInquisitiveness() {
        return inquisitiveness;
    }

    public void setInquisitiveness(int inquisitiveness) {
        this.inquisitiveness = inquisitiveness;
    }

    @Basic
    @Column(name = "creativity")
    public int getCreativity() {
        return creativity;
    }

    public void setCreativity(int creativity) {
        this.creativity = creativity;
    }

    @Basic
    @Column(name = "unconventionality")
    public int getUnconventionality() {
        return unconventionality;
    }

    public void setUnconventionality(int unconventionality) {
        this.unconventionality = unconventionality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HexacoResultDbEntity that = (HexacoResultDbEntity) o;
        return key == that.key &&
                userKey == that.userKey &&
                honestyHumility == that.honestyHumility &&
                emotionality == that.emotionality &&
                extraversion == that.extraversion &&
                agreeableness == that.agreeableness &&
                conscientiousness == that.conscientiousness &&
                opennessToExperience == that.opennessToExperience &&
                altruism == that.altruism &&
                sincerity == that.sincerity &&
                fairness == that.fairness &&
                greedAvoidance == that.greedAvoidance &&
                modesty == that.modesty &&
                fearfulness == that.fearfulness &&
                anxiety == that.anxiety &&
                dependence == that.dependence &&
                sentimentality == that.sentimentality &&
                socialSelfEsteem == that.socialSelfEsteem &&
                socialBoldness == that.socialBoldness &&
                sociability == that.sociability &&
                liveliness == that.liveliness &&
                forgiveness == that.forgiveness &&
                gentleness == that.gentleness &&
                flexibility == that.flexibility &&
                patience == that.patience &&
                organization == that.organization &&
                diligence == that.diligence &&
                perfectionism == that.perfectionism &&
                prudence == that.prudence &&
                aestheticAppreciation == that.aestheticAppreciation &&
                inquisitiveness == that.inquisitiveness &&
                creativity == that.creativity &&
                unconventionality == that.unconventionality &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, userKey, name, honestyHumility, emotionality, extraversion, agreeableness, conscientiousness, opennessToExperience, altruism, sincerity, fairness, greedAvoidance, modesty, fearfulness, anxiety, dependence, sentimentality, socialSelfEsteem, socialBoldness, sociability, liveliness, forgiveness, gentleness, flexibility, patience, organization, diligence, perfectionism, prudence, aestheticAppreciation, inquisitiveness, creativity, unconventionality);
    }
}
