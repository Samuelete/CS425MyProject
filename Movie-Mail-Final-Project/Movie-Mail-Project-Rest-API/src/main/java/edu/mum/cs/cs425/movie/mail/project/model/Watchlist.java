package edu.mum.cs.cs425.movie.mail.project.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Watchlist {
	
	private static final Integer MAXIMUM_DVDS_WATCHLIST = 50;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long watchlistId;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<DVD> watchListDvds;

	public Watchlist() {
		super();
	}

	public Watchlist(Long watchlistId, List<DVD> watchListDvds) {
		super();
		this.watchlistId = watchlistId;
		this.watchListDvds = watchListDvds;
	}

	public Long getWatchlistId() {
		return watchlistId;
	}

	public void setWatchlistId(Long watchlistId) {
		this.watchlistId = watchlistId;
	}

	public List<DVD> getWatchListDvds() {
		return watchListDvds;
	}

	public void setWatchListDvds(List<DVD> watchListDvds) {
		this.watchListDvds = watchListDvds;
	}

	public void addDvdToWatchlist(DVD dvd) {
		if(watchListDvds == null) {
			watchListDvds = new ArrayList<>();
		}
		
		if(watchListDvds.size() == MAXIMUM_DVDS_WATCHLIST) {
			return;
		}
		
		if(dvd != null) {
			watchListDvds.add(dvd);
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(watchListDvds, watchlistId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Watchlist other = (Watchlist) obj;
		return Objects.equals(watchListDvds, other.watchListDvds) && Objects.equals(watchlistId, other.watchlistId);
	}

	@Override
	public String toString() {
		return String.format("Watchlist [watchlistId=%s, watchListDvds=%s]", watchlistId, watchListDvds);
	}

	
	
}
