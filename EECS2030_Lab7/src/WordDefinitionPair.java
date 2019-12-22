public class WordDefinitionPair {

	private String word;
	private String def;

	WordDefinitionPair() {
		this.word = null;
		this.def = null;
	}

	WordDefinitionPair(String word, String definition) {
		this.word = word;
		this.def = definition;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getDefinition() {
		return def;
	}

	public void setDefenition(String definition) {
		this.def = definition;
	}

	boolean isEmpty() {
		return this.word == null && this.def == null;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		WordDefinitionPair other = (WordDefinitionPair) obj;
		if (this.word.equals(other.word) && this.def.equals(other.def)) {
			return true;
		}

		return false;

	}

}