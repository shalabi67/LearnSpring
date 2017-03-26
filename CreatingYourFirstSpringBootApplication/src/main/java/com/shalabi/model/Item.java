package com.shalabi.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NamedQueries( {
        @NamedQuery(name= Item.ALL_ITEMS, query="select i from Item i"),
        @NamedQuery(name= Item.ITEMS_WITHOUT_REVIEW, query="select i from Item i where i.reviews.size=0"),
        @NamedQuery(name= Item.RATED_ITEMS_LESS_THAN_RATING,
                query="select i from Item i left join i.reviews r group by i.id having avg(r.rating)<:rating")
})
public class Item {
  public  static final String ALL_ITEMS = "allItems";
  public  static final String ITEMS_WITHOUT_REVIEW = "itemsWithoutReview";
  public  static final String RATED_ITEMS_LESS_THAN_RATING = "ratedItemsLessThanRating";

  @Id
  @GeneratedValue
  private Long id;

  @Column(length = 100)
  @NotEmpty
  private String title;

  @Column(length = 200)
  private String description;

  @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Review> reviews = new HashSet<>();

  public Item(String title, String description) {
    this.title = title;
    this.description = description;
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public Set<Review> getReviews() {
    return reviews;
  }

  public void addReview(Review review) {
    reviews.add(review);
    review.setItem(this);
  }

  @Override
  public String toString() {
    return "\nItem{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", description='" + description + '\'' +
        ", reviews=" + reviews +
        '}';
  }
}
