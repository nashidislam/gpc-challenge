
public class Position {
	private int xCordinate;
	private int yCordinate;
	private String direction;
	
	
	public Position(int xCordinate, int yCordinate, String direction) {
		this.xCordinate = xCordinate;
		this.yCordinate = yCordinate;
		this.direction = direction;
	}
	public Position(){
		this.xCordinate = 0;
		this.yCordinate = 0;
		this.direction = "N";
	}
	public int getxCordinate() {
		return xCordinate;
	}
	public void setxCordinate(int xCordinate) {
		this.xCordinate = xCordinate;
	}
	public int getyCordinate() {
		return yCordinate;
	}
	public void setyCordinate(int yCordinate) {
		this.yCordinate = yCordinate;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Position [xCordinate=");
		builder.append(xCordinate);
		builder.append(", yCordinate=");
		builder.append(yCordinate);
		builder.append(", direction=");
		builder.append(direction);
		builder.append("]");
		return builder.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direction == null) ? 0 : direction.hashCode());
		result = prime * result + xCordinate;
		result = prime * result + yCordinate;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (direction == null) {
			if (other.direction != null)
				return false;
		} else if (!direction.equals(other.direction))
			return false;
		if (xCordinate != other.xCordinate)
			return false;
		if (yCordinate != other.yCordinate)
			return false;
		return true;
	}
}
