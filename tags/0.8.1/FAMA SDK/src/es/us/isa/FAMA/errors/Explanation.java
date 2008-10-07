/*
	This file is part of FaMaTS.

    FaMaTS is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    FaMaTS is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with FaMaTS.  If not, see <http://www.gnu.org/licenses/>.

 */
package es.us.isa.FAMA.errors;

import java.util.Collection;
import java.util.HashSet;

import es.us.isa.FAMA.models.featureModel.GenericRelation;


public class Explanation {
	private Collection<GenericRelation> relations;
	
	public Explanation() {
		relations = new HashSet<GenericRelation>();
	}
	
	public Explanation(Collection<GenericRelation> rels) {
		relations = new HashSet<GenericRelation>();
		relations.addAll(rels);
	}
	
	public void addRelation (GenericRelation rel) {
		relations.add(rel);
	}
	
	public Collection<GenericRelation> getRelations(){
		return this.relations;
	}
}
