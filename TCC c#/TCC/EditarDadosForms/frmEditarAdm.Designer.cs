namespace TCC.EditarDadosForms
{
    partial class frmEditarAdm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle3 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle4 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle1 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle2 = new System.Windows.Forms.DataGridViewCellStyle();
            this.btnVoltar = new System.Windows.Forms.Label();
            this.lblMensagem = new System.Windows.Forms.Label();
            this.lblUsuario = new System.Windows.Forms.Label();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.btnPesquisar = new System.Windows.Forms.Button();
            this.txtID = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.txtNome = new System.Windows.Forms.TextBox();
            this.lblPesquisarNome = new System.Windows.Forms.Label();
            this.dtDisplay = new System.Windows.Forms.DataGridView();
            this.lblRedorDireito = new System.Windows.Forms.Label();
            this.btnChangeProfile = new System.Windows.Forms.Label();
            this.btnSair = new System.Windows.Forms.Label();
            this.lblNumeroMensagens = new System.Windows.Forms.Label();
            this.btnMensagens = new System.Windows.Forms.Label();
            this.btnNotas = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.btnEditarPrestador = new System.Windows.Forms.Label();
            this.btnEditarServico = new System.Windows.Forms.Label();
            this.btnEditarAdm = new System.Windows.Forms.Label();
            this.btnEditarUsuario = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.lblRedor = new System.Windows.Forms.Label();
            this.lblSetinha = new System.Windows.Forms.Label();
            this.btnNovoAdm = new System.Windows.Forms.Button();
            this.btnDeletar = new System.Windows.Forms.DataGridViewImageColumn();
            this.txtIDdgv = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.txtNomedgv = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.txtSenhadgv = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.txtLoginAdm = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.txtEmail = new System.Windows.Forms.DataGridViewTextBoxColumn();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dtDisplay)).BeginInit();
            this.SuspendLayout();
            // 
            // btnVoltar
            // 
            this.btnVoltar.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnVoltar.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnVoltar.Image = global::TCC.Properties.Resources.voltar;
            this.btnVoltar.Location = new System.Drawing.Point(99, 488);
            this.btnVoltar.Name = "btnVoltar";
            this.btnVoltar.Size = new System.Drawing.Size(119, 66);
            this.btnVoltar.TabIndex = 63;
            this.btnVoltar.Click += new System.EventHandler(this.btnVoltar_Click);
            this.btnVoltar.Paint += new System.Windows.Forms.PaintEventHandler(this.btnVoltar_Paint);
            // 
            // lblMensagem
            // 
            this.lblMensagem.ForeColor = System.Drawing.Color.ForestGreen;
            this.lblMensagem.Location = new System.Drawing.Point(747, 65);
            this.lblMensagem.MaximumSize = new System.Drawing.Size(11000, 17);
            this.lblMensagem.Name = "lblMensagem";
            this.lblMensagem.Size = new System.Drawing.Size(120, 17);
            this.lblMensagem.TabIndex = 62;
            // 
            // lblUsuario
            // 
            this.lblUsuario.AutoSize = true;
            this.lblUsuario.BackColor = System.Drawing.Color.Transparent;
            this.lblUsuario.ForeColor = System.Drawing.Color.Black;
            this.lblUsuario.Location = new System.Drawing.Point(962, 68);
            this.lblUsuario.Name = "lblUsuario";
            this.lblUsuario.Size = new System.Drawing.Size(32, 17);
            this.lblUsuario.TabIndex = 61;
            this.lblUsuario.Text = "aaa";
            // 
            // pictureBox1
            // 
            this.pictureBox1.Image = global::TCC.Properties.Resources.imgNomeLogin1;
            this.pictureBox1.Location = new System.Drawing.Point(929, 46);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(179, 63);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBox1.TabIndex = 60;
            this.pictureBox1.TabStop = false;
            // 
            // btnPesquisar
            // 
            this.btnPesquisar.Location = new System.Drawing.Point(638, 44);
            this.btnPesquisar.Name = "btnPesquisar";
            this.btnPesquisar.Size = new System.Drawing.Size(81, 61);
            this.btnPesquisar.TabIndex = 59;
            this.btnPesquisar.Text = "Pesquisar";
            this.btnPesquisar.UseVisualStyleBackColor = true;
            this.btnPesquisar.Click += new System.EventHandler(this.btnPesquisar_Click_1);
            // 
            // txtID
            // 
            this.txtID.Location = new System.Drawing.Point(450, 83);
            this.txtID.Name = "txtID";
            this.txtID.Size = new System.Drawing.Size(163, 22);
            this.txtID.TabIndex = 58;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(330, 85);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(92, 17);
            this.label2.TabIndex = 57;
            this.label2.Text = "Pesquisar ID:";
            // 
            // txtNome
            // 
            this.txtNome.Location = new System.Drawing.Point(450, 44);
            this.txtNome.Name = "txtNome";
            this.txtNome.Size = new System.Drawing.Size(163, 22);
            this.txtNome.TabIndex = 56;
            // 
            // lblPesquisarNome
            // 
            this.lblPesquisarNome.AutoSize = true;
            this.lblPesquisarNome.Location = new System.Drawing.Point(330, 45);
            this.lblPesquisarNome.Name = "lblPesquisarNome";
            this.lblPesquisarNome.Size = new System.Drawing.Size(114, 17);
            this.lblPesquisarNome.TabIndex = 55;
            this.lblPesquisarNome.Text = "Pesquisar nome:";
            // 
            // dtDisplay
            // 
            this.dtDisplay.AllowUserToAddRows = false;
            this.dtDisplay.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dtDisplay.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.btnDeletar,
            this.txtIDdgv,
            this.txtNomedgv,
            this.txtSenhadgv,
            this.txtLoginAdm,
            this.txtEmail});
            this.dtDisplay.Location = new System.Drawing.Point(332, 134);
            this.dtDisplay.Name = "dtDisplay";
            dataGridViewCellStyle3.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleCenter;
            dataGridViewCellStyle3.BackColor = System.Drawing.SystemColors.Control;
            dataGridViewCellStyle3.Font = new System.Drawing.Font("Microsoft Sans Serif", 7.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            dataGridViewCellStyle3.ForeColor = System.Drawing.SystemColors.WindowText;
            dataGridViewCellStyle3.SelectionBackColor = System.Drawing.SystemColors.Highlight;
            dataGridViewCellStyle3.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
            dataGridViewCellStyle3.WrapMode = System.Windows.Forms.DataGridViewTriState.True;
            this.dtDisplay.RowHeadersDefaultCellStyle = dataGridViewCellStyle3;
            this.dtDisplay.RowHeadersWidth = 51;
            dataGridViewCellStyle4.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleLeft;
            this.dtDisplay.RowsDefaultCellStyle = dataGridViewCellStyle4;
            this.dtDisplay.RowTemplate.Height = 30;
            this.dtDisplay.Size = new System.Drawing.Size(776, 437);
            this.dtDisplay.TabIndex = 54;
            this.dtDisplay.CellClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dtDisplay_CellClick);
            this.dtDisplay.CellValueChanged += new System.Windows.Forms.DataGridViewCellEventHandler(this.dtDisplay_CellValueChanged);
            // 
            // lblRedorDireito
            // 
            this.lblRedorDireito.Location = new System.Drawing.Point(313, 23);
            this.lblRedorDireito.Name = "lblRedorDireito";
            this.lblRedorDireito.Size = new System.Drawing.Size(816, 564);
            this.lblRedorDireito.TabIndex = 53;
            this.lblRedorDireito.Paint += new System.Windows.Forms.PaintEventHandler(this.lblRedorDireito_Paint);
            // 
            // btnChangeProfile
            // 
            this.btnChangeProfile.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnChangeProfile.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnChangeProfile.Image = global::TCC.Properties.Resources.trocar_usuario_2;
            this.btnChangeProfile.Location = new System.Drawing.Point(46, 386);
            this.btnChangeProfile.Name = "btnChangeProfile";
            this.btnChangeProfile.Size = new System.Drawing.Size(224, 66);
            this.btnChangeProfile.TabIndex = 51;
            this.btnChangeProfile.Click += new System.EventHandler(this.btnChangeProfile_Click);
            this.btnChangeProfile.Paint += new System.Windows.Forms.PaintEventHandler(this.btnChangeProfile_Paint);
            // 
            // btnSair
            // 
            this.btnSair.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnSair.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnSair.Image = global::TCC.Properties.Resources.turn_off_41;
            this.btnSair.Location = new System.Drawing.Point(46, 321);
            this.btnSair.Name = "btnSair";
            this.btnSair.Size = new System.Drawing.Size(224, 66);
            this.btnSair.TabIndex = 50;
            this.btnSair.Paint += new System.Windows.Forms.PaintEventHandler(this.btnSair_Paint);
            // 
            // lblNumeroMensagens
            // 
            this.lblNumeroMensagens.AutoSize = true;
            this.lblNumeroMensagens.BackColor = System.Drawing.SystemColors.ControlLight;
            this.lblNumeroMensagens.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblNumeroMensagens.ForeColor = System.Drawing.SystemColors.HotTrack;
            this.lblNumeroMensagens.Location = new System.Drawing.Point(239, 292);
            this.lblNumeroMensagens.Name = "lblNumeroMensagens";
            this.lblNumeroMensagens.Size = new System.Drawing.Size(18, 20);
            this.lblNumeroMensagens.TabIndex = 49;
            this.lblNumeroMensagens.Text = "0";
            this.lblNumeroMensagens.Click += new System.EventHandler(this.btnMensagens_Click);
            this.lblNumeroMensagens.MouseEnter += new System.EventHandler(this.lblNumeroMensagens_MouseEnter);
            this.lblNumeroMensagens.MouseLeave += new System.EventHandler(this.lblNumeroMensagens_MouseLeave);
            // 
            // btnMensagens
            // 
            this.btnMensagens.BackColor = System.Drawing.SystemColors.ControlLight;
            this.btnMensagens.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnMensagens.Font = new System.Drawing.Font("Kotori Rose", 8.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnMensagens.ForeColor = System.Drawing.SystemColors.HotTrack;
            this.btnMensagens.Location = new System.Drawing.Point(48, 286);
            this.btnMensagens.Name = "btnMensagens";
            this.btnMensagens.Padding = new System.Windows.Forms.Padding(8, 9, 0, 0);
            this.btnMensagens.Size = new System.Drawing.Size(219, 35);
            this.btnMensagens.TabIndex = 48;
            this.btnMensagens.Text = "MENSAGENS";
            this.btnMensagens.Click += new System.EventHandler(this.btnMensagens_Click);
            this.btnMensagens.MouseEnter += new System.EventHandler(this.btnMensagens_MouseEnter);
            this.btnMensagens.MouseLeave += new System.EventHandler(this.btnMensagens_MouseLeave);
            // 
            // btnNotas
            // 
            this.btnNotas.BackColor = System.Drawing.SystemColors.ControlLight;
            this.btnNotas.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnNotas.Font = new System.Drawing.Font("Kotori Rose", 8.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnNotas.ForeColor = System.Drawing.SystemColors.HotTrack;
            this.btnNotas.Location = new System.Drawing.Point(48, 251);
            this.btnNotas.Name = "btnNotas";
            this.btnNotas.Padding = new System.Windows.Forms.Padding(8, 9, 0, 0);
            this.btnNotas.Size = new System.Drawing.Size(219, 35);
            this.btnNotas.TabIndex = 47;
            this.btnNotas.Text = "NOTAS";
            this.btnNotas.Click += new System.EventHandler(this.btnNotas_Click);
            this.btnNotas.MouseEnter += new System.EventHandler(this.btnNotas_MouseEnter);
            this.btnNotas.MouseLeave += new System.EventHandler(this.btnNotas_MouseLeave);
            // 
            // label6
            // 
            this.label6.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.label6.Font = new System.Drawing.Font("Leelawadee UI", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label6.Location = new System.Drawing.Point(46, 218);
            this.label6.Name = "label6";
            this.label6.Padding = new System.Windows.Forms.Padding(8, 3, 0, 0);
            this.label6.Size = new System.Drawing.Size(224, 33);
            this.label6.TabIndex = 46;
            this.label6.Text = "MENSAGENS";
            // 
            // btnEditarPrestador
            // 
            this.btnEditarPrestador.BackColor = System.Drawing.SystemColors.ControlLight;
            this.btnEditarPrestador.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnEditarPrestador.Font = new System.Drawing.Font("Kotori Rose", 8.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnEditarPrestador.ForeColor = System.Drawing.SystemColors.HotTrack;
            this.btnEditarPrestador.Location = new System.Drawing.Point(48, 148);
            this.btnEditarPrestador.Name = "btnEditarPrestador";
            this.btnEditarPrestador.Padding = new System.Windows.Forms.Padding(8, 9, 0, 0);
            this.btnEditarPrestador.Size = new System.Drawing.Size(219, 35);
            this.btnEditarPrestador.TabIndex = 45;
            this.btnEditarPrestador.Text = "EDITAR PRESTADOR";
            this.btnEditarPrestador.Click += new System.EventHandler(this.btnEditarPrestador_Click);
            this.btnEditarPrestador.MouseEnter += new System.EventHandler(this.btnEditarPrestador_MouseEnter);
            this.btnEditarPrestador.MouseLeave += new System.EventHandler(this.btnEditarPrestador_MouseLeave);
            // 
            // btnEditarServico
            // 
            this.btnEditarServico.BackColor = System.Drawing.SystemColors.ControlLight;
            this.btnEditarServico.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnEditarServico.Font = new System.Drawing.Font("Kotori Rose", 8.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnEditarServico.ForeColor = System.Drawing.SystemColors.HotTrack;
            this.btnEditarServico.Location = new System.Drawing.Point(48, 113);
            this.btnEditarServico.Name = "btnEditarServico";
            this.btnEditarServico.Padding = new System.Windows.Forms.Padding(8, 9, 0, 0);
            this.btnEditarServico.Size = new System.Drawing.Size(219, 35);
            this.btnEditarServico.TabIndex = 44;
            this.btnEditarServico.Text = "EDITAR SERVIÇO";
            this.btnEditarServico.Click += new System.EventHandler(this.btnEditarServico_Click);
            this.btnEditarServico.MouseEnter += new System.EventHandler(this.btnEditarServico_MouseEnter);
            this.btnEditarServico.MouseLeave += new System.EventHandler(this.btnEditarServico_MouseLeave);
            // 
            // btnEditarAdm
            // 
            this.btnEditarAdm.BackColor = System.Drawing.SystemColors.ControlLight;
            this.btnEditarAdm.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnEditarAdm.Font = new System.Drawing.Font("Kotori Rose", 8.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnEditarAdm.ForeColor = System.Drawing.SystemColors.HotTrack;
            this.btnEditarAdm.Location = new System.Drawing.Point(48, 183);
            this.btnEditarAdm.Name = "btnEditarAdm";
            this.btnEditarAdm.Padding = new System.Windows.Forms.Padding(8, 9, 0, 0);
            this.btnEditarAdm.Size = new System.Drawing.Size(219, 35);
            this.btnEditarAdm.TabIndex = 43;
            this.btnEditarAdm.Text = "EDITAR ADM";
            this.btnEditarAdm.MouseEnter += new System.EventHandler(this.btnEditarAdm_MouseEnter);
            this.btnEditarAdm.MouseLeave += new System.EventHandler(this.btnEditarAdm_MouseLeave);
            // 
            // btnEditarUsuario
            // 
            this.btnEditarUsuario.BackColor = System.Drawing.SystemColors.ControlLight;
            this.btnEditarUsuario.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnEditarUsuario.Font = new System.Drawing.Font("Kotori Rose", 8.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnEditarUsuario.ForeColor = System.Drawing.SystemColors.HotTrack;
            this.btnEditarUsuario.Location = new System.Drawing.Point(48, 78);
            this.btnEditarUsuario.Name = "btnEditarUsuario";
            this.btnEditarUsuario.Padding = new System.Windows.Forms.Padding(8, 9, 0, 0);
            this.btnEditarUsuario.Size = new System.Drawing.Size(219, 35);
            this.btnEditarUsuario.TabIndex = 42;
            this.btnEditarUsuario.Text = "EDITAR USUÁRIO";
            this.btnEditarUsuario.Click += new System.EventHandler(this.btnEditarUsuario_Click);
            this.btnEditarUsuario.MouseEnter += new System.EventHandler(this.btnEditarUsuario_MouseEnter);
            this.btnEditarUsuario.MouseLeave += new System.EventHandler(this.btnEditarUsuario_MouseLeave);
            // 
            // label1
            // 
            this.label1.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.label1.Font = new System.Drawing.Font("Leelawadee UI", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(46, 45);
            this.label1.Name = "label1";
            this.label1.Padding = new System.Windows.Forms.Padding(8, 3, 0, 0);
            this.label1.Size = new System.Drawing.Size(224, 33);
            this.label1.TabIndex = 41;
            this.label1.Text = "EDIÇÃO";
            // 
            // lblRedor
            // 
            this.lblRedor.BackColor = System.Drawing.SystemColors.ControlLightLight;
            this.lblRedor.Location = new System.Drawing.Point(26, 24);
            this.lblRedor.Name = "lblRedor";
            this.lblRedor.Size = new System.Drawing.Size(264, 564);
            this.lblRedor.TabIndex = 52;
            this.lblRedor.Paint += new System.Windows.Forms.PaintEventHandler(this.lblRedor_Paint);
            // 
            // lblSetinha
            // 
            this.lblSetinha.AutoSize = true;
            this.lblSetinha.BackColor = System.Drawing.SystemColors.ControlLight;
            this.lblSetinha.Font = new System.Drawing.Font("Kotori Rose", 10.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblSetinha.ForeColor = System.Drawing.Color.RoyalBlue;
            this.lblSetinha.Location = new System.Drawing.Point(239, 189);
            this.lblSetinha.Name = "lblSetinha";
            this.lblSetinha.Size = new System.Drawing.Size(21, 23);
            this.lblSetinha.TabIndex = 64;
            this.lblSetinha.Text = "<";
            this.lblSetinha.MouseEnter += new System.EventHandler(this.lblSetinha_MouseEnter);
            this.lblSetinha.MouseLeave += new System.EventHandler(this.lblSetinha_MouseLeave);
            // 
            // btnNovoAdm
            // 
            this.btnNovoAdm.Location = new System.Drawing.Point(739, 44);
            this.btnNovoAdm.Name = "btnNovoAdm";
            this.btnNovoAdm.Size = new System.Drawing.Size(81, 61);
            this.btnNovoAdm.TabIndex = 65;
            this.btnNovoAdm.Text = "Criar novo ADM";
            this.btnNovoAdm.UseVisualStyleBackColor = true;
            this.btnNovoAdm.Click += new System.EventHandler(this.btnNovoAdm_Click);
            // 
            // btnDeletar
            // 
            dataGridViewCellStyle1.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleCenter;
            dataGridViewCellStyle1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(102)))), ((int)(((byte)(204)))));
            dataGridViewCellStyle1.Font = new System.Drawing.Font("Gilroy ExtraBold", 7.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            dataGridViewCellStyle1.ForeColor = System.Drawing.Color.Transparent;
            dataGridViewCellStyle1.NullValue = null;
            dataGridViewCellStyle1.SelectionBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(102)))), ((int)(((byte)(204)))));
            dataGridViewCellStyle1.SelectionForeColor = System.Drawing.Color.White;
            this.btnDeletar.DefaultCellStyle = dataGridViewCellStyle1;
            this.btnDeletar.FillWeight = 22.28826F;
            this.btnDeletar.HeaderText = "";
            this.btnDeletar.Image = global::TCC.Properties.Resources.lixo;
            this.btnDeletar.ImageLayout = System.Windows.Forms.DataGridViewImageCellLayout.Zoom;
            this.btnDeletar.MinimumWidth = 6;
            this.btnDeletar.Name = "btnDeletar";
            this.btnDeletar.ReadOnly = true;
            this.btnDeletar.Resizable = System.Windows.Forms.DataGridViewTriState.False;
            this.btnDeletar.Width = 30;
            // 
            // txtIDdgv
            // 
            this.txtIDdgv.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.DisplayedCells;
            this.txtIDdgv.DataPropertyName = "id_adm";
            dataGridViewCellStyle2.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleCenter;
            dataGridViewCellStyle2.BackColor = System.Drawing.Color.SkyBlue;
            this.txtIDdgv.DefaultCellStyle = dataGridViewCellStyle2;
            this.txtIDdgv.HeaderText = "ID";
            this.txtIDdgv.MinimumWidth = 6;
            this.txtIDdgv.Name = "txtIDdgv";
            this.txtIDdgv.Width = 50;
            // 
            // txtNomedgv
            // 
            this.txtNomedgv.DataPropertyName = "nome";
            this.txtNomedgv.FillWeight = 114.0032F;
            this.txtNomedgv.HeaderText = "Nome";
            this.txtNomedgv.MinimumWidth = 6;
            this.txtNomedgv.Name = "txtNomedgv";
            this.txtNomedgv.Width = 156;
            // 
            // txtSenhadgv
            // 
            this.txtSenhadgv.DataPropertyName = "senha";
            this.txtSenhadgv.FillWeight = 118.1039F;
            this.txtSenhadgv.HeaderText = "Senha";
            this.txtSenhadgv.MinimumWidth = 6;
            this.txtSenhadgv.Name = "txtSenhadgv";
            this.txtSenhadgv.ReadOnly = true;
            this.txtSenhadgv.Visible = false;
            this.txtSenhadgv.Width = 159;
            // 
            // txtLoginAdm
            // 
            this.txtLoginAdm.DataPropertyName = "login_adm";
            this.txtLoginAdm.FillWeight = 121.4429F;
            this.txtLoginAdm.HeaderText = "Login";
            this.txtLoginAdm.MinimumWidth = 6;
            this.txtLoginAdm.Name = "txtLoginAdm";
            this.txtLoginAdm.Width = 164;
            // 
            // txtEmail
            // 
            this.txtEmail.DataPropertyName = "email";
            this.txtEmail.FillWeight = 124.1618F;
            this.txtEmail.HeaderText = "Email";
            this.txtEmail.MinimumWidth = 6;
            this.txtEmail.Name = "txtEmail";
            this.txtEmail.Width = 167;
            // 
            // frmEditarAdm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ControlLightLight;
            this.ClientSize = new System.Drawing.Size(1155, 612);
            this.Controls.Add(this.btnNovoAdm);
            this.Controls.Add(this.lblSetinha);
            this.Controls.Add(this.btnVoltar);
            this.Controls.Add(this.lblMensagem);
            this.Controls.Add(this.lblUsuario);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.btnPesquisar);
            this.Controls.Add(this.txtID);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.txtNome);
            this.Controls.Add(this.lblPesquisarNome);
            this.Controls.Add(this.dtDisplay);
            this.Controls.Add(this.lblRedorDireito);
            this.Controls.Add(this.btnChangeProfile);
            this.Controls.Add(this.btnSair);
            this.Controls.Add(this.lblNumeroMensagens);
            this.Controls.Add(this.btnMensagens);
            this.Controls.Add(this.btnNotas);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.btnEditarPrestador);
            this.Controls.Add(this.btnEditarServico);
            this.Controls.Add(this.btnEditarAdm);
            this.Controls.Add(this.btnEditarUsuario);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.lblRedor);
            this.Name = "frmEditarAdm";
            this.Text = "Editar ADM";
            this.Load += new System.EventHandler(this.frmEditarAdm_Load);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dtDisplay)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label btnVoltar;
        private System.Windows.Forms.Label lblMensagem;
        private System.Windows.Forms.Label lblUsuario;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Button btnPesquisar;
        private System.Windows.Forms.TextBox txtID;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox txtNome;
        private System.Windows.Forms.Label lblPesquisarNome;
        private System.Windows.Forms.DataGridView dtDisplay;
        private System.Windows.Forms.Label lblRedorDireito;
        private System.Windows.Forms.Label btnChangeProfile;
        private System.Windows.Forms.Label btnSair;
        private System.Windows.Forms.Label lblNumeroMensagens;
        private System.Windows.Forms.Label btnMensagens;
        private System.Windows.Forms.Label btnNotas;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label btnEditarPrestador;
        private System.Windows.Forms.Label btnEditarServico;
        private System.Windows.Forms.Label btnEditarAdm;
        private System.Windows.Forms.Label btnEditarUsuario;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label lblRedor;
        private System.Windows.Forms.Label lblSetinha;
        private System.Windows.Forms.Button btnNovoAdm;
        private System.Windows.Forms.DataGridViewImageColumn btnDeletar;
        private System.Windows.Forms.DataGridViewTextBoxColumn txtIDdgv;
        private System.Windows.Forms.DataGridViewTextBoxColumn txtNomedgv;
        private System.Windows.Forms.DataGridViewTextBoxColumn txtSenhadgv;
        private System.Windows.Forms.DataGridViewTextBoxColumn txtLoginAdm;
        private System.Windows.Forms.DataGridViewTextBoxColumn txtEmail;
    }
}