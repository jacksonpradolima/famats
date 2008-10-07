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
package es.us.isa.ChocoReasoner.questions;

import java.util.Collection;

import es.us.isa.ChocoReasoner.ChocoQuestion;
import es.us.isa.ChocoReasoner.ChocoReasoner;
import es.us.isa.ChocoReasoner.ChocoResult;
import es.us.isa.FAMA.Benchmarking.PerformanceResult;
import es.us.isa.FAMA.Reasoner.Reasoner;
import es.us.isa.FAMA.Reasoner.questions.ExtendedFilterQuestion;
import es.us.isa.FAMA.Reasoner.questions.SetQuestion;
import es.us.isa.FAMA.Reasoner.questions.ValidConfigurationQuestion;
import es.us.isa.FAMA.Reasoner.questions.ValidQuestion;
import es.us.isa.FAMA.Reasoner.questions.defaultImpl.DefaultValidConfigurationQuestion;
import es.us.isa.FAMA.models.featureModel.GenericFeature;
import es.us.isa.FAMA.models.featureModel.Product;

public class ChocoValidConfigurationQuestion extends ChocoQuestion implements
		ValidConfigurationQuestion {

	DefValidConfigurationQuestion vcq;
	
	public ChocoValidConfigurationQuestion() {
		super();
		vcq = new DefValidConfigurationQuestion();
	}

	@Override
	public boolean isValid() {
		return vcq.isValid();
	}

	@Override
	public void setProduct(Product p) {
		vcq.setProduct(p);
	}
	
	public PerformanceResult answer(Reasoner r){
		ChocoReasoner choco = (ChocoReasoner) r;
		this.vcq.setAllFeatures(choco.getAllFeatures());
		return this.vcq.answer(r);
	}
	
	class DefValidConfigurationQuestion extends DefaultValidConfigurationQuestion{

		Collection<GenericFeature> c;
		
		@Override
		public ExtendedFilterQuestion filterQuestionFactory() {
			return new ChocoExtendedFilterQuestion();
		}

		public void setAllFeatures(Collection<GenericFeature> c){
			this.c = c;
		}
		
		@Override
		public Collection<GenericFeature> getAllFeatures() {
			return c;
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
