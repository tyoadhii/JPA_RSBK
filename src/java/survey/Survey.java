/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survey;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kukuh
 */
@Entity
@Table(name = "survey")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Survey.findAll", query = "SELECT s FROM Survey s")
    , @NamedQuery(name = "Survey.findByNama", query = "SELECT s FROM Survey s WHERE s.nama = :nama")
    , @NamedQuery(name = "Survey.findByEmail", query = "SELECT s FROM Survey s WHERE s.email = :email")
    , @NamedQuery(name = "Survey.findByAlamat", query = "SELECT s FROM Survey s WHERE s.alamat = :alamat")
    , @NamedQuery(name = "Survey.findByKota", query = "SELECT s FROM Survey s WHERE s.kota = :kota")
    , @NamedQuery(name = "Survey.findByNegBag", query = "SELECT s FROM Survey s WHERE s.negBag = :negBag")
    , @NamedQuery(name = "Survey.findByPos", query = "SELECT s FROM Survey s WHERE s.pos = :pos")
    , @NamedQuery(name = "Survey.findByTgl", query = "SELECT s FROM Survey s WHERE s.tgl = :tgl")
    , @NamedQuery(name = "Survey.findByRadio", query = "SELECT s FROM Survey s WHERE s.radio = :radio")
    , @NamedQuery(name = "Survey.findByHow", query = "SELECT s FROM Survey s WHERE s.how = :how")
    , @NamedQuery(name = "Survey.findByRekomendasi", query = "SELECT s FROM Survey s WHERE s.rekomendasi = :rekomendasi")
    , @NamedQuery(name = "Survey.findByKomentar", query = "SELECT s FROM Survey s WHERE s.komentar = :komentar")})
public class Survey implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nama")
    private String nama;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "alamat")
    private String alamat;
    @Size(max = 255)
    @Column(name = "kota")
    private String kota;
    @Size(max = 255)
    @Column(name = "negBag")
    private String negBag;
    @Size(max = 255)
    @Column(name = "pos")
    private String pos;
    @Column(name = "tgl")
    @Temporal(TemporalType.DATE)
    private Date tgl;
    @Size(max = 255)
    @Column(name = "radio")
    private String radio;
    @Size(max = 255)
    @Column(name = "how")
    private String how;
    @Size(max = 255)
    @Column(name = "rekomendasi")
    private String rekomendasi;
    @Size(max = 255)
    @Column(name = "komentar")
    private String komentar;

    public Survey() {
    }

    public Survey(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getNegBag() {
        return negBag;
    }

    public void setNegBag(String negBag) {
        this.negBag = negBag;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public Date getTgl() {
        return tgl;
    }

    public void setTgl(Date tgl) {
        this.tgl = tgl;
    }

    public String getRadio() {
        return radio;
    }

    public void setRadio(String radio) {
        this.radio = radio;
    }

    public String getHow() {
        return how;
    }

    public void setHow(String how) {
        this.how = how;
    }

    public String getRekomendasi() {
        return rekomendasi;
    }

    public void setRekomendasi(String rekomendasi) {
        this.rekomendasi = rekomendasi;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nama != null ? nama.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Survey)) {
            return false;
        }
        Survey other = (Survey) object;
        if ((this.nama == null && other.nama != null) || (this.nama != null && !this.nama.equals(other.nama))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "survey.Survey[ nama=" + nama + " ]";
    }
    
}
