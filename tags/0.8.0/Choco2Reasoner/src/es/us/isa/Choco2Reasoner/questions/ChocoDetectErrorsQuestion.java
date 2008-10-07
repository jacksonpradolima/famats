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
package es.us.isa.Choco2Reasoner.questions;

import java.util.Collection;

import es.us.isa.Choco2Reasoner.ChocoQuestion;
import es.us.isa.Choco2Reasoner.ChocoResult;
import es.us.isa.FAMA.Benchmarking.PerformanceResult;
import es.us.isa.FAMA.Reasoner.Reasoner;
import es.us.isa.FAMA.Reasoner.questions.DetectErrorsQuestion;
import es.us.isa.FAMA.Reasoner.questions.FilterQuestion;
import es.us.isa.FAMA.Reasoner.questions.SetQuestion;
import es.us.isa.FAMA.Reasoner.questions.ValidQuestion;
import es.us.isa.FAMA.Reasoner.questions.defaultImpl.DefaultDetectErrorsQuestion;
import es.us.isa.FAMA.errors.Error;
import es.us.isa.FAMA.errors.Observation;

public class ChocoDetectErrorsQuestion extends ChocoQuestion implements
		DetectErrorsQuestion {

	private DefDetectErrorsQuestion deq;
	
	public ChocoDetectErrorsQuestion() {
		super();
		deq = new DefDetectErrorsQuestion();
	}

	@Override
	public Collection<Error> getErrors() {
		return deq.getErrors();
	}

	@Override
	public void setObservations(Collection<Observation> observations) {
		deq.setObservations(observations);
	}
	
	public PerformanceResult answer(Reasoner r){
		return this.deq.answer(r);
	}
	
	public String toString(){
		return this.deq.toString();
	}
	
	class DefDetectErrorsQuestion extends DefaultDetectErrorsQuestion{

		@Override
		public FilterQuestion filterQuestionFactory() {
			return new ChocoFilterQuestion();
		}

		@Override
		public PerformanceResult performanceResultFactory() {
			return new ChocoResult();
		}

		@Override
		public SetQuestion setQuestionFactory() {
			return new ChocoSetQuestion();
		}

		@Override
		public ValidQuestion validQuestionFactory() {
			return new ChocoValidQuestion();
		}

		@Override
		public Class<? extends Reasoner> getReasonerClass() {
			return null;
		}
		
	}

}