pipeline {
  agent { label 'migration' }
  tools {
        maven 'apache-maven-latest'
        jdk 'oracle-jdk8-latest'
  }
  parameters {
    string(name: 'CORE_BRANCH', defaultValue: 'master', description: 'When build is not triggered by diffmerge-core build, set the branch of diffmerge-core')
  }
  environment {
    FROM_GITHUB = "${BRANCH_NAME}".contains("PR-");
    BUILD_KEY = "${params.CORE_BRANCH}-${BRANCH_NAME}-${BUILD_ID}-patterns".replaceFirst(/^v/, "").replaceAll('/','-');
    
    SSH_ACCOUNT = "genie.diffmerge@projects-storage.eclipse.org"
    BUILD_DIR = "/home/data/httpd/download.eclipse.org/diffmerge/nightly/${BUILD_KEY}"
    
  }
  stages {
    stage('Package') {
      steps {
        sh "mvn -Dcore.repo.url=https://download.eclipse.org/diffmerge/nightly/${params.CORE_BRANCH}/emf-diffmerge-site/ clean install -t ${WORKSPACE}/releng/org.eclipse.emf.diffmerge.patterns.configuration/toolchains-hipp.xml -Psign"
      }
    }
    stage('Publish artifacts') {
      steps {
        sshagent ( ['projects-storage.eclipse.org-bot-ssh']) {
            sh "ssh $SSH_ACCOUNT mkdir -p $BUILD_DIR/edm-patterns-site"
            sh "scp -rp $WORKSPACE/releng/org.eclipse.emf.diffmerge.patterns.update/target/repository/* $SSH_ACCOUNT:$BUILD_DIR/edm-patterns-site"
        }
        script {		
		     currentBuild.description = "${BUILD_KEY} - <a href=\"https://download.eclipse.org/diffmerge/nightly/${BUILD_KEY}\">site</a>" 				
	   	}
      }
    }
  }
}