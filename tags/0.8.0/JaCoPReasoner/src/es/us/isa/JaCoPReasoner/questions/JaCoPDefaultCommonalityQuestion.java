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
package es.us.isa.JaCoPReasoner.questions;

import java.util.Collection;

import es.us.isa.FAMA.Benchmarking.PerformanceResult;
import es.us.isa.FAMA.Reasoner.Reasoner;
import es.us.isa.FAMA.Reasoner.questions.CommonalityQuestion;
import es.us.isa.FAMA.Reasoner.questions.FilterQuestion;
import es.us.isa.FAMA.Reasoner.questions.NumberOfProductsQuestion;
import es.us.isa.FAMA.Reasoner.questions.SetQuestion;
import es.us.isa.FAMA.Reasoner.questions.defaultImpl.DefaultCommonalityQuestion;
import es.us.isa.FAMA.models.featureModel.GenericFeature;
import es.us.isa.JaCoPReasoner.JaCoPQuestion;
import es.us.isa.JaCoPReasoner.JaCoPReasoner;
import es.us.isa.JaCoPReasoner.JaCoPResult;

public class JaCoPDefaultCommonalityQuestion extends JaCoPQuestion implements
		CommonalityQuestion {

	private DefCommonalityQuestion cq;
	
	public JaCoPDefaultCommonalityQuestion() {
		super();
		cq = new DefCommonalityQuestion();
	}

	public long getCommonality() {
		return cq.getCommonality();
	}

	public void setFeature(GenericFeature arg0) {
		cq.setFeature(arg0);
	}
	
	public void preAnswer(JaCoPReasoner r){
		this.cq.preAnswer(r);
	}
	
	public PerformanceResult answer(JaCoPReasoner r){
		this.cq.setFeatures(r.getAllFeatures());
		return this.cq.answer(r);
	}

	public String toString(){
		return this.cq.toString();
	}
	
	class DefCommonalityQuestion extends DefaultCommonalityQuestion{

		Collection<GenericFeature> c;
		
		@Override
		public FilterQuestion filterQuestionFactory() {
			return new JaCoPFilterQuestion();
		}

		@Override
		public NumberOfProductsQuestion numberOfProductsQuestionFactory() {
			return new JaCoPNumberOfProductsQuestion();
		}

		@Override
		public PerformanceResult performanceResultFactory() {
			return new JaCoPResult();
		}

		@Override
		public SetQuestion setQuestionFactory() {
			return new JaCoPSetQuestion();
		}

		public Class<? extends Reasoner> getReasonerClass() {
			return null;
		}

		public void setFeatures(Collection<GenericFeature> c){
			this.c = c;
		}
		
		@Override
		public boolean isValid(GenericFeature arg0) {
			// TODO Auto-generated method stub
			return c.contains(arg0);
			
		}
		
	}
	
}
