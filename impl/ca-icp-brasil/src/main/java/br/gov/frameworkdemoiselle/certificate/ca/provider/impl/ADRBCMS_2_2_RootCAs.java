/*
 * Demoiselle Framework
 * Copyright (C) 2010 SERPRO
 * ----------------------------------------------------------------------------
 * This file is part of Demoiselle Framework.
 *
 * Demoiselle Framework is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License version 3
 * along with this program; if not,  see <http://www.gnu.org/licenses/>
 * or write to the Free Software Foundation, Inc., 51 Franklin Street,
 * Fifth Floor, Boston, MA  02110-1301, USA.
 * ----------------------------------------------------------------------------
 * Este arquivo é parte do Framework Demoiselle.
 *
 * O Framework Demoiselle é um software livre; você pode redistribuí-lo e/ou
 * modificá-lo dentro dos termos da GNU LGPL versão 3 como publicada pela Fundação
 * do Software Livre (FSF).
 *
 * Este programa é distribuído na esperança que possa ser útil, mas SEM NENHUMA
 * GARANTIA; sem uma garantia implícita de ADEQUAÇÃO a qualquer MERCADO ou
 * APLICAÇÃO EM PARTICULAR. Veja a Licença Pública Geral GNU/LGPL em português
 * para maiores detalhes.
 *
 * Você deve ter recebido uma cópia da GNU LGPL versão 3, sob o título
 * "LICENCA.txt", junto com esse programa. Se não, acesse <http://www.gnu.org/licenses/>
 * ou escreva para a Fundação do Software Livre (FSF) Inc.,
 * 51 Franklin St, Fifth Floor, Boston, MA 02111-1301, USA.
 */
package br.gov.frameworkdemoiselle.certificate.ca.provider.impl;

import java.io.InputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.gov.frameworkdemoiselle.certificate.ca.provider.ProviderSignaturePolicyRootCA;

/**
 * @deprecated replaced by Demoiselle SIGNER
 * @see <a href="https://github.com/demoiselle/signer/">https://github.com/demoiselle/signer</a>
 * 
 */
@Deprecated
public class ADRBCMS_2_2_RootCAs implements ProviderSignaturePolicyRootCA {

    @Override
    public Collection<X509Certificate> getCAs() {
        List<X509Certificate> result = new ArrayList<X509Certificate>();
        InputStream icpBrasilv2 = ADRBCMS_2_2_RootCAs.class.getClassLoader().getResourceAsStream("trustedca/ICP-Brasilv2.crt");
        InputStream icpBrasilv5 = ADRBCMS_2_2_RootCAs.class.getClassLoader().getResourceAsStream("trustedca/ICP-Brasilv5.crt");
        try {
            result.add((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(icpBrasilv2));
            result.add((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(icpBrasilv5));
        } catch (CertificateException e) {
        }
        return result;
    }

    @Override
    public String getSignaturePolicyOID() {
        return "2.16.76.1.7.1.1.2.2";
    }
}
