package persistance.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import persistance.entity.tuple.ComboTuple;

/**
 * Entity implementation class for Entity: Combo
 *
 */

@Entity
public class Combo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "combo_sequence")
	@SequenceGenerator(name = "combo_sequence", sequenceName = "combo_sequence", allocationSize = 1)
	@Column(updatable = false, nullable = false)
	private Long id;

	@Column(updatable = true, nullable = false)
	private String name;

	@Column(updatable = true, nullable = true)
	private String description;

	@Temporal(TemporalType.DATE)
	@Column(updatable = false, nullable = false)
	private Date creationDate;

	@Embedded
	private Color color;

	@ManyToOne
	@JoinColumn(updatable = false, nullable = false)
	private Member member;

	@OneToMany
	@JoinColumn(name = "combo_id", nullable = false)
	private Set<ComboTuple> cards;

	// ManyToMany cards (+ cardsQuantity);

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Set<ComboTuple> getCards() {
		return cards;
	}

	public void setCards(Set<ComboTuple> cards) {
		this.cards = cards;
	}

}
