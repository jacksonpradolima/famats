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
package es.us.isa.JaCoPReasoner;

import JaCoP.Delete;
import JaCoP.SelectVariable;
import es.us.isa.FAMA.Benchmarking.PerformanceResult;
import es.us.isa.FAMA.Reasoner.Question;
import es.us.isa.FAMA.Reasoner.Reasoner;

public abstract class JaCoPQuestion implements Question {
	public Class<? extends Reasoner> getReasonerClass() {
		return JaCoPReasoner.class;
	}
	
	protected SelectVariable heuristics;
	
	public JaCoPQuestion() {
		heuristics = new Delete();
	}
	
	public void setHeuristics (SelectVariable heuristics) {
		this.heuristics = heuristics;
	}
	
	public void preAnswer(JaCoPReasoner r) {}
	public PerformanceResult answer(JaCoPReasoner r) {return null;}
	public void postAnswer(JaCoPReasoner r) {}
}
